package theAnime.patches;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import javassist.CtBehavior;
import theAnime.AnimeMod;
import theAnime.cardmods.LockedMod;

@SpirePatch(clz = AbstractPlayer.class, method = "useCard")
public class LockedPatch {

    //@SpireInsertPatch(locator = Locator.class)
    public static void Postfix(AbstractPlayer p, AbstractCard c, AbstractMonster m, int energyonuse) {
        if (!c.freeToPlayOnce && CardModifierManager.hasModifier(c, LockedMod.ID)) {
            for (AbstractCardModifier r : CardModifierManager.getModifiers(c, LockedMod.ID)) {
                if (r instanceof LockedMod) {
                    if (!((LockedMod) r).unlocked) {
                        int x = ((LockedMod) r).amount;
                        int i = 0;
                        while (x > 0 && i < AbstractDungeon.player.hand.size()) {
                            AbstractCard q = AbstractDungeon.player.hand.group.get(i);
                            if (q.hasTag(AnimeMod.KEY)) {
                                AbstractDungeon.player.hand.moveToExhaustPile(q);// 33
                                q.exhaustOnUseOnce = false;// 35
                                q.freeToPlayOnce = false;// 36
                                x--;
                            } else i++;
                        }
                    }
                }
            }
        }
    }

    /*
    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher matcher = new Matcher.FieldAccessMatcher(AbstractPlayer.class, "cardInUse");
            return LineFinder.findInOrder(ctMethodToPatch, matcher);
        }
    }
    */

}