package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.actions.KillEnemyAction;
import theAnime.cards.AbstractTodoCard;
import theAnime.util.TextureLoader;

public class DoomingPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("DoomingPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_32.png");

    public DoomingPower(AbstractCreature owner) {
        name = "Doom Dummy";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onDeath() {
        flash();
        for (AbstractMonster m : AbstractTodoCard.monsterList()) {
            AbstractDungeon.actionManager.addToBottom(new KillEnemyAction(m));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new DoomingPower(owner);
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, #rso #rdo #rALL #renemies.";
    }
}