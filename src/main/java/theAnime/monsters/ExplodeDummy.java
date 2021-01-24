package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.ExplodingPower;

public class ExplodeDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("ExplodeDummy");
    private int special;

    public ExplodeDummy(float x, float y, int hp, int special) {
        super(ID, x, y, hp);
        this.special = special;
        myColor = Color.RED.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new ExplodingPower(this, special));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new ExplodeDummy(x2, y2, basehp, special);
    }
}
