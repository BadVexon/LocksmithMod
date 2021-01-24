package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.ReflectHexPower;

public class HexxDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("HexxDummy");

    public HexxDummy(float x, float y, int hp) {
        super(ID, x, y, hp);
        myColor = Color.PURPLE.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new ReflectHexPower(this));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new HexxDummy(x2, y2, basehp);
    }
}
