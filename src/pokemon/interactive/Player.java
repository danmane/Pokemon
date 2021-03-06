package pokemon.interactive;

import pokemon.core.Pokemon;

import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nolan
 * Date: 5/11/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    private boolean inBattle;
    private int money;
    private final String NAME;
    private Bag bag;
    private Pokemon[] party;

    public Player(final String name) {
        inBattle = false;
        this.money = 0;
        NAME = name;
        this.bag = new Bag();
        this.party = new Pokemon[6];
    }

    public boolean isInBattle() {
        return inBattle;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return NAME;
    }

    public Bag getBag() {
        return this.bag;
    }

    public Pokemon[] getParty() {
        return this.party;
    }

    public void setBattleState(final boolean inBattle) {
        this.inBattle = inBattle;
    }

    public boolean isPartyEmpty() {
        for(final Pokemon p : getParty()) {
            if(p != null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Attempts to add a <code>Pokemon</code> to your party.
     * @param pokemon <code>Pokemon</code> to add to the party.
     * @return <code>true</code> if the pokemon was added, <code>false</code> otherwise.
     */
    public boolean addToParty(final Pokemon pokemon)
    {
        for(int i = 0; i < party.length; i++)
        {
            if(party[i] == null) {
                party[i] = pokemon;
                return true;
            }
        }
        return false;
    }

    public boolean swapSlots(final int one, final int two) {
        if((one < 0 || one > 5) || (two < 0 || two > 5)) {
            return false;
        }
        final Pokemon temp = getParty()[one];
        this.party[one] = this.party[two];
        this.party[two] = temp;
        return true;
    }

    @Override
    public String toString() {
        return "Name: " + getName() +
               "\nMoney: " + getMoney() +
               "\nBag contents " + getBag().getMap() +
               "\nParty contents " + Arrays.toString(getParty());
    }
}
