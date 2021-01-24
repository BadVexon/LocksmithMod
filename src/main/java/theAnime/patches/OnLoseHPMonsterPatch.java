package theAnime.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import javassist.CtBehavior;
import theAnime.powers.OnLoseHpMonsterPower;

@SpirePatch(clz = AbstractMonster.class, method = "damage")
public class OnLoseHPMonsterPatch {
    @SpireInsertPatch(locator = Locator.class, localvars = "damageAmount")
    public static void Insert(AbstractMonster m, DamageInfo info, int damageAmount) {
        for (AbstractPower p : m.powers) {
            if (p instanceof OnLoseHpMonsterPower) ((OnLoseHpMonsterPower) p).onLoseHpMonster(m.lastDamageTaken);
        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.FieldAccessMatcher(AbstractMonster.class, "currentHealth");
            return new int[]{LineFinder.findAllInOrder(ctMethodToPatch, matcher)[2]};
        }
    }
}