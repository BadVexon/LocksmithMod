package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardGroup.CardGroupType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class UnearthAction extends AbstractGameAction {
    private AbstractPlayer player;

    public UnearthAction() {
        this.actionType = ActionType.CARD_MANIPULATION;// 19
        this.duration = this.startDuration = Settings.ACTION_DUR_FAST;// 20
        this.player = AbstractDungeon.player;// 21
    }// 23

    public void update() {
        if (this.duration == this.startDuration) {// 26
            if (this.player.exhaustPile.isEmpty()) {// 27
                this.isDone = true;// 28
            } else {
                CardGroup temp = new CardGroup(CardGroupType.UNSPECIFIED);// 31

                for (AbstractCard c : this.player.exhaustPile.group) {
                    temp.addToTop(c);// 33
                }

                temp.sortAlphabetically(true);// 35
                temp.sortByRarityPlusStatusCardType(false);// 36
                AbstractDungeon.gridSelectScreen.open(temp, 1, "Choose a card to play.", false);// 37
                this.tickDuration();// 38
            }
        } else {
            if (!AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {// 42

                for (AbstractCard c : AbstractDungeon.gridSelectScreen.selectedCards) {
                    c.exhaust = true;// 44
                    AbstractDungeon.player.exhaustPile.group.remove(c);// 45
                    AbstractDungeon.getCurrRoom().souls.remove(c);// 46
                    this.addToBot(new NewQueueCardAction(c, true, false, true));// 50
                }

                AbstractDungeon.gridSelectScreen.selectedCards.clear();// 59
                AbstractDungeon.player.hand.refreshHandLayout();// 60
            }

            this.tickDuration();// 62
        }
    }// 29 39 63
}
