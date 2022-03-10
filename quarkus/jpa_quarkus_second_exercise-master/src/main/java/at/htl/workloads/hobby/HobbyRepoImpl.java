package at.htl.workloads.hobby;

import at.htl.result.ItemHobby;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class HobbyRepoImpl implements HobbyRepo {

    private final EntityManager entityManager;

    public HobbyRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void add(Hobby hobby) {
        this.entityManager.persist(hobby);
    }

    @Override
    public Hobby getHobby(Long hobbyId) {
        TypedQuery<Hobby> query = this.entityManager
                .createQuery("select h from Hobby h where h.id = :id",
                        Hobby.class);
        query.setParameter("id", hobbyId);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public Map<String, Long> getHobbyistCount() {
        TypedQuery<CountResult> query = this.entityManager
                .createQuery("select NEW " +
                        "at.htl.workloads.hobby.CountResult(h.description, count(p.id)) " +
                        "from Interest i " +
                        "join i.id.person p " +
                        "join i.id.hobby h " +
                        "group by h.id", CountResult.class);
        return query.getResultStream()
                .collect(Collectors.toMap(CountResult::desc,
                        CountResult::count));
    }

    @Override
    public List<ItemHobby> theMostPopularItemPerHobby() {

        TypedQuery<Long> queryHobbyId = this.entityManager
                .createQuery("SELECT h.id from Hobby h group by h", Long.class);
        List<Long> hobbyIds = queryHobbyId.getResultStream().toList();

        if (hobbyIds.size() == 0){
            return null;
        }

        List<ItemHobby> hobbyItemRecordList = new ArrayList<>();

        for(long id : hobbyIds){
            Long popularProductId = this.entityManager
                    .createQuery("select oi.Pcode from OrderItem oi, Interest i where i.id.hobby.id = :id and oi.id.orderr.person = i.id.person group by oi.Pcode order by count(oi.Pcode) desc ", Long.class)
                    .setParameter("id", id)
                    .setMaxResults(1)
                    .getResultStream().findFirst().orElse(null);
            if (popularProductId != null){
                hobbyItemRecordList.add(new ItemHobby(popularProductId,id));
            }
        }

        return hobbyItemRecordList;
    }
}
