package theAnime.patches;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import javassist.CtBehavior;

@SpirePatch(clz = AbstractCard.class, method = "renderEnergy")
public class CostColorPatchSet {

    @SpireInsertPatch(locator = Locator.class)
    public static void Insert(AbstractCard c, SpriteBatch sb) {
        FixLockedCanUsePatch.ACTIVE = false;
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.FieldAccessMatcher(Color.class, "WHITE");
            return LineFinder.findInOrder(ctMethodToPatch, matcher);
        }
    }
}