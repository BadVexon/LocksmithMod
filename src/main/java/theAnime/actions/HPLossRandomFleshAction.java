package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.cards.AbstractTodoCard;
import theAnime.monsters.AbstractDummy;

import java.util.ArrayList;

public class HPLossRandomFleshAction extends AbstractGameAction {
    private AbstractMonster m;

    public HPLossRandomFleshAction(AbstractMonster m, int dfgdfg) {
        amount = dfgdfg;
        this.m = m;
        this.actionType = ActionType.DAMAGE;// 13
    }// 15

    public void update() {
        ArrayList<AbstractMonster> qmonsterlist = AbstractTodoCard.monsterList();
        qmonsterlist.removeIf(m -> m instanceof AbstractDummy);
        if (!qmonsterlist.isEmpty()) {
            this.target = qmonsterlist.get(AbstractDungeon.cardRandomRng.random(qmonsterlist.size() - 1));
            if (this.target != null) {// 20
                this.addToTop(new LoseHPAction(target, m, amount));
            }
        }


        this.isDone = true;// 23
    }// 24
}
