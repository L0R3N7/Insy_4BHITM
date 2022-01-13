package at.htl;

import at.htl.model.Penalty;
import at.htl.model.Player;
import at.htl.results.GenderCount;
import at.htl.results.MinMaxAmount;
import at.htl.results.PlayerPenalties;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class Repository {

    private final EntityManager entityManager;

    public Repository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Returns players living in a specified town
     *
     * @param town name of the town
     */
    public List<Player> getPlayersLivingInTown(String town) {
        TypedQuery<Player> playerTypedQuery =  entityManager
                .createQuery("select p from Player p where p.town = :town", Player.class)
                .setParameter("town", town);
        return playerTypedQuery.getResultStream().collect(Collectors.toList());
    }

    /**
     * Returns players living in one of the specified towns
     *
     * @param towns names of towns
     */
    public List<Player> getPlayersLivingInTowns(List<String> towns) {
        TypedQuery<Player> playerTypedQuery =  entityManager
                .createQuery("select p from Player p where p.town in :town", Player.class)
                .setParameter("town", towns);
        return playerTypedQuery.getResultStream().collect(Collectors.toList());
    }

    /**
     * Returns players of a certain gender born before a specified year
     *
     * @param female         male or female
     * @param bornBeforeYear the exclusive year before someone has to be born
     */
    public List<Player> getPlayersWithGenderAndAge(boolean female, int bornBeforeYear) {
        Character sex = (female)?('F'):('M');

        TypedQuery<Player> playerTypedQuery =  entityManager
                .createQuery("select p from Player p where p.yearOfBirth < :bornBeforeYear and p.sex = :sex", Player.class)
                .setParameter("bornBeforeYear", bornBeforeYear)
                .setParameter("sex", sex);
        return playerTypedQuery.getResultStream().collect(Collectors.toList());
    }

    /**
     * Returns penalties issued between two dates
     *
     * @param start the first (earlier) date, inclusive
     * @param end   the second (later) date, inclusive
     */
    public List<Penalty> getPenaltiesInDateRange(LocalDate start, LocalDate end) {
        TypedQuery<Penalty> penaltyTypedQuery = entityManager
                .createQuery("select p from Penalty p where p.penDate between :start and :end", Penalty.class)
                .setParameter("start", start)
                .setParameter("end", end);

        return penaltyTypedQuery.getResultList();
    }

    /**
     * Returns penalties with an amount higher or equal to the specified amount
     */
    public List<Penalty> getPenaltiesWithAmountHigherEqualThan(BigDecimal amount) {
        TypedQuery<Penalty> penaltyTypedQuery = entityManager
                .createQuery("select p from Penalty p where p.amount >= :amount", Penalty.class)
                .setParameter("amount", amount);

        return penaltyTypedQuery.getResultList();
    }

    /**
     * Returns the average penalty sum calculated over all penalties
     */
    public Double getAveragePenaltyAmount() {
        TypedQuery<Double> penaltyTypedQuery = entityManager
                .createQuery("select avg(p.amount) from Penalty p ", Double.class);

        return penaltyTypedQuery.getSingleResult();
    }

    /**
     * Returns the min & max penalty amount
     */
    public MinMaxAmount getMinMaxPenaltyAmount() {
        TypedQuery<MinMaxAmount> typedQuery = entityManager
                .createQuery("select new at.htl.results.MinMaxAmount(min(p.amount), max(p.amount)) from Penalty p",
                        MinMaxAmount.class);

        return typedQuery.getSingleResult();
    }

    /**
     * Returns all players who either have or have not received a penalty so far
     *
     * @param hasPenalty flag indicating if we want to look for players with or without penalties
     */
    public List<Player> getPlayersWithPenalties(boolean hasPenalty) {

        String notOrNot = (!hasPenalty)?"":"not";

        TypedQuery<Player> playerTypedQuery =  entityManager
                .createQuery("select p from Player p where p.penalties is " + notOrNot + " EMPTY", Player.class);
        return playerTypedQuery.getResultStream().collect(Collectors.toList());
    }

    /**
     * Returns the names of those towns who have at least as many players as specified
     *
     * @param minNoOfPlayers the min. number of players a town has to have
     */
    public List<String> getTownsWithPlayerNumber(Long minNoOfPlayers) {
        TypedQuery<String> playerTypedQuery =  entityManager
                .createQuery("select p.town from Player p group by p.town having count(p) >= :minNoOfPlayers ", String.class)
                .setParameter("minNoOfPlayers", minNoOfPlayers);
        return playerTypedQuery.getResultStream().collect(Collectors.toList());
    }

    /**
     * Returns the number of players for each gender
     */
    public Map<Character, Long> getPlayerCountsByGender() {
        TypedQuery<GenderCount> typedQuery =
                entityManager.createQuery("select new at.htl.results.GenderCount(p.sex, count(p)) from Player p group by p.sex", GenderCount.class);

        return typedQuery.
    }

    /**
     * Returns the penalty sum for all players, including those who never received a penalty (sum = 0)
     */
    public List<PlayerPenalties> getPenaltiesForAllPlayers() {
        return null;
    }
}
