package theAnime.monsters;

import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.TimeskipPower;

public class DioDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("DioDummy");

    public DioDummy(float x, float y, int hp) {
        super(ID, x, y, hp);
        myColor = AnimeMod.rainbow;
    }

    @Override
    public void update() {
        super.update();
        myColor = AnimeMod.rainbow;
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new TimeskipPower(this));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new DioDummy(x2, y2, basehp);
    }
}
