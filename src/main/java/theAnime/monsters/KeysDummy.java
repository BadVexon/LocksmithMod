package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.StuffedWithKeysPower;

public class KeysDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("KeysDummy");

    public KeysDummy(float x, float y, int hp) {
        super(ID, x, y, hp);
        myColor = Color.YELLOW.cpy();
    }

    @Override
    public void usePreBattleAction() {
        applyToSelf(new StuffedWithKeysPower(this, 2));
    }

    @Override
    public AbstractMonster makeCopy() {
        return new KeysDummy(x2, y2, basehp);
    }
}
