package theAnime.patches;

import com.evacipated.cardcrawl.modthespire.lib.*;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.MinionPower;
import javassist.CtBehavior;
import theAnime.actions.KillEnemyAction;
import theAnime.cards.AbstractTodoCard;
import theAnime.monsters.AbstractDummy;
import theAnime.powers.OnMonsterDeathPower;

@SpirePatch(
        clz = AbstractMonster.class,
        method = "die",
        paramtypez = {boolean.class}
)
public class OnEnemyDeath {
    @SpireInsertPatch(
            locator = Locator.class
    )
    public static void triggerOnDeathPowers(AbstractMonster __instance, boolean triggerRelics) {
        //check for minions

        for (AbstractPower q : AbstractDungeon.player.powers) {
            if (q instanceof OnMonsterDeathPower) ((OnMonsterDeathPower) q).onMonsterDeath(__instance);
        }

        for (AbstractMonster t : AbstractTodoCard.monsterList()) {
            for (AbstractPower r : t.powers) {
                if (r instanceof OnMonsterDeathPower) ((OnMonsterDeathPower) r).onMonsterDeath(__instance);
            }
        }

        boolean allMinion = true;
        for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
            if (!m.isDeadOrEscaped() && !m.hasPower(MinionPower.POWER_ID)) {
                allMinion = false;
                break;
            }
        }

        if (allMinion) {
            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                if (!m.isDeadOrEscaped() && (m instanceof AbstractDummy))
                    AbstractDungeon.actionManager.addToBottom(new KillEnemyAction(m));
            }
        }
    }

    private static class Locator extends SpireInsertLocator {
        @Override
        public int[] Locate(CtBehavior ctMethodToPatch) throws Exception {
            Matcher finalMatcher = new Matcher.MethodCallMatcher(MonsterGroup.class, "areMonstersBasicallyDead");
            return LineFinder.findInOrder(ctMethodToPatch, finalMatcher);
        }
    }
}