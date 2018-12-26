package souza.bruno.deckofmanytools.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import souza.bruno.deckofmanytools.ui.fragments.CommonDiceRoller;
import souza.bruno.deckofmanytools.ui.fragments.DiceRoller;
import souza.bruno.deckofmanytools.ui.fragments.Initiative;
import souza.bruno.deckofmanytools.ui.fragments.Welcome;

public class PageAdapter extends FragmentPagerAdapter {

    private int numTabs;

    public PageAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: return new Welcome();
            case 1: return new CommonDiceRoller();
            case 2: return new Initiative();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
