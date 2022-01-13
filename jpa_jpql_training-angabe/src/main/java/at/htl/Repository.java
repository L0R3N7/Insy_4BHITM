package at.htl;

import at.htl.model.Penalty;
import at.htl.model.Player;
import at.htl.results.GenderCount;
import at.htl.results.MinMaxAmount;
import at.htl.results.PlayerPenalties;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
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
        return null;
    }

    /**
     * Returns players living in one of the specified towns
     *
     * @param towns names of towns
     */
    public List<Player> getPlayersLivingInTowns(List<String> towns) {
        return null;
    }

    /**
     * Returns players of a certain gender born before a specified year
     *
     * @param female         male or female
     * @param bornBeforeYear the exclusive year before someone has to be born
     */
    public List<Player> getPlayersWithGenderAndAge(boolean female, int bornBeforeYear) {
        return null;
    }

    /**
     * Returns penalties issued between two dates
     *
     * @param start the first (earlier) date, inclusive
     * @param end   the second (later) date, inclusive
     */
    public List<Penalty> getPenaltiesInDateRange(LocalDate start, LocalDate end) {
        return null;
    }

    /**
     * Returns penalties with an amount higher or equal to the specified amount
     */
    public List<Penalty> getPenaltiesWithAmountHigherEqualThan(BigDecimal amount) {
        return null;
    }

    /**
     * Returns the average penalty sum calculated over all penalties
     */
    public Double getAveragePenaltyAmount() {
        return null;
    }

    /**
     * Returns the min & max penalty amount
     */
    public MinMaxAmount getMinMaxPenaltyAmount() {
        return null;
    }

    /**
     * Returns all players who either have or have not received a penalty so far
     *
     * @param hasPenalty flag indicating if we want to look for players with or without penalties
     */
    public List<Player> getPlayersWithPenalties(boolean hasPenalty) {
        return null;
    }

    /**
     * Returns the names of those towns who have at least as many players as specified
     *
     * @param minNoOfPlayers the min. number of players a town has to have
     */
    public List<String> getTownsWithPlayerNumber(Long minNoOfPlayers) {
        return null;
    }

    /**
     * Returns the number of players for each gender
     */
    public Map<Character, Long> getPlayerCountsByGender() {
        return null;
    }

    /**
     * Returns the penalty sum for all players, including those who never received a penalty (sum = 0)
     */
    public List<PlayerPenalties> getPenaltiesForAllPlayers() {
        return null;
    }
}