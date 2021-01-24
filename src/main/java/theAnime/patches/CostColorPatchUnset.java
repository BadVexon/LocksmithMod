package theAnime.patches;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import javassist.CtBehavior;

@SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
public class CostColorPatchUnset {

    @SpireInsertPatch(locator = Locator.class)
    public static void Insert(AbstractCard c, SpriteBatch sb) {
        FixLockedCanUsePatch.ACTIVE = true;
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.FieldAccessMatcher(AbstractCard.class, "transparency");
            return LineFinder.findInOrder(ctMethodToPatch, matcher);
        }
    }
}