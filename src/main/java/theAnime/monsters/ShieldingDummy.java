package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.ReflectBlockPower;

public class ShieldingDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("ShieldingDummy");

    public ShieldingDummy(float x, float y, int hp) {
        super(ID, x, y, hp);
        myColor = Color.NAVY.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new ReflectBlockPower(this));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new ShieldingDummy(x2, y2, basehp);
    }
}
