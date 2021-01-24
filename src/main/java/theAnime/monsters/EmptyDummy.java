package theAnime.monsters;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class EmptyDummy extends AbstractDummy {
    public static String ID = AnimeMod.makeID("EmptyDummy");

    public EmptyDummy(float x, float y, int hp) {
        super(ID, x, y, hp);
        myColor = Color.WHITE.cpy();
    }

    @Override
    public AbstractMonster makeCopy() {
        return new EmptyDummy(x2, y2, basehp);
    }
}
