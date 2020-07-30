package CowKiller.antiban;

import CowKiller.task.AbstractTask;
import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;

public class CollectionAntiBanTask extends AbstractTask {
    //Misc Antiban Variables
    public Boolean checkXP = true;
    public Boolean deepSleep = true;
    public Boolean checkSpeak = true;
    public Boolean checkRun = true;
    public Boolean checkFriends = true;
    public Boolean checkIgnore = true;
    public Boolean checkEquipment = true;
    public Boolean checkMusic = true;
    public Boolean checkCC = true;
    public Boolean checkCombatStyle = true;
    public Boolean checkTotal = true;
    public Boolean checkQuickPray = true;
    public Boolean checkQuest = true;
    public Boolean checkInventory = true;
    public Boolean checkLogout = true;
    public Boolean checkWorldMap = true;
    public Boolean checkChatOptions = true; //Game,Public,Private,Clan,Trade,Report
    public Boolean checkSettings = true;
    public Boolean checkSpells = true;

    //Skills Antiban Variables
    public Boolean checkPrayer = true;
    public Boolean checkHerb = true;
    public Boolean checkFish = true;
    public Boolean checkSlayer = true;
    public Boolean checkSmithing = true;
    public Boolean checkFiremaking = true;
    public Boolean checkHitpoints = true;
    public Boolean checkRange = true;
    public Boolean checkMining = true;
    public Boolean checkRunecrafting = true;
    public Boolean checkAttack = true;
    public Boolean checkStrength = true;
    public Boolean checkMagic = true;
    public Boolean checkDefence = true;
    public Boolean checkConstruction = true;
    public Boolean checkAgility = true;
    public Boolean checkThieving = true;
    public Boolean checkCrafting = true;
    public Boolean checkFletching = true;
    public Boolean checkHunter = true;
    public Boolean checkCooking = true;
    public Boolean checkWoodcutting = true;
    public Boolean checkFarming = true;

    public int switcher;

    public int randomizerFive = Random.nextInt(1,5);
    public int randomizerFifteen = Random.nextInt(1,15);
    public int randomizerThirty = Random.nextInt(1,30);

    Random random = new Random();

    public CollectionAntiBanTask(ClientContext ctx) {
        super(ctx);
    }

    public void execute(int min,int max) {
        int low = min;
        int high = max;

        antiban(low,high);
    }

    /*----------------------------------------*\
    *******************Antiban******************
    /*----------------------------------------*/

    public void antiban(int l, int h) {
        //widgetBuilder(161,40); //Emote
        int low = l;
        int high = h;

        switcher = random.nextInt(1,1600);

        //Switch statement that intakes the random number generated for switcher, and looks to see if that number satisfies a case.
        switch (switcher) {
            default:
                //Sleeps for a time specified between random integers ranging from x to y milliseconds
                Condition.sleep(org.powerbot.script.Random.nextInt(low, high));
                break;
            case 1:
                if (checkPrayer) {
                    checkPraySkill();
                }
                break;

            case 2:
                if (checkXP) {
                    xpAlter();
                }
                break;
            case 5:
                if (deepSleep) {
                    Condition.sleep(org.powerbot.script.Random.nextInt(3000, 6000));
                }
                break;
            case 6:
                if(checkSpeak){
                    System.out.println("Tried to Speak");
                    speak();
                }
                break;
            case 7:
                if(checkRun) {
                    run();
                }
                break;
            case 8:
                if(checkEquipment) {
                    checkEquipment();
                }
                break;
            case 9:
                if(checkFriends) {
                    checkFriendsList();
                }
                break;
            case 10:
                if(checkHerb) {
                    checkHerb();
                }
                break;
            case 11:
                if(checkSlayer) {
                    checkSlayer();
                }
                break;
            case 12:
                if(checkFish) {
                    checkFish();
                }
                break;
            case 13:
                if(checkHitpoints) {
                    checkHitpoints();
                }
                break;
            case 14:
                if(checkFiremaking) {
                    checkkFiremaking();
                }
                break;
            case 15:
                if(checkRange) {
                    checkRange();
                }
                break;
            case 16:
                if(checkMining) {
                    checkMining();
                }
                break;
            case 17:
                if(checkRunecrafting) {
                    checkRunecrafting();
                }
                break;
            case 18:
                if(checkAttack) {
                    checkAttack();
                }
                break;
            case 19:
                if(checkStrength) {
                    checkStrength();
                }
                break;
            case 20:
                if(checkSmithing) {
                    checkSmithing();
                }
                break;
            case 21:
                if(checkMagic){
                    checkMagic();
                }
                break;
            case 22:
                if(checkCC){
                    checkClanChat();
                }
                break;
            case 23:
                if(checkMusic){
                    checkMusic();
                }
                break;
            case 24:
                if(checkCombatStyle) {
                    checkCombatStyle();
                }
                break;
            case 25:
                if(checkDefence) {
                    checkDefence();
                }
                break;
            case 26:
                if(checkConstruction) {
                    checkConstruction();
                }
                break;
            case 27:
                if(checkAgility) {
                    checkAgility();
                }
                break;
            case 28:
                if(checkThieving) {
                    checkThieving();
                }
                break;
            case 29:
                if(checkCrafting) {
                    checkCrafting();
                }
                break;
            case 30:
                if(checkFletching) {
                    checkFletching();
                }
                break;
            case 31:
                if(checkHunter) {
                    checkHunter();
                }
                break;
            case 32:
                if(checkCooking) {
                    checkCooking();
                }
                break;
            case 33:
                if(checkFarming) {
                    checkFarming();
                }
                break;
            case 34:
                if(checkWoodcutting) {
                    checkWoodCutting();
                }
                break;
            case 35:
                if(checkIgnore) {
                    checkIgnoreList();
                }
                break;
            case 36:
                if(checkTotal){
                    checkTotal();
                }
                break;
            case 37:
                if(checkQuickPray) {
                    checkQuickPray();
                }
                break;
            case 38:
                if(checkQuest) {
                    checkQuest();
                }
                break;
            case 40:
                if(checkInventory) {
                    checkInventory();
                }
                break;
            case 41:
                if(checkLogout) {
                    checkLogout();
                }
                break;
            case 42:
                if(checkWorldMap) {
                    checkWorldMap();
                }
                break;
            case 43:
                if(checkChatOptions) {
                    checkChatOptions();
                }
                break;
            case 44:
                if(checkSpells){
                    checkSpells();
                }
                break;
            case 45:
                if(checkSettings) {
                    checkSettings();
                }
                break;
        } // End of Switch Statement for Antiban
    } // End of Antiban Function

    /*----------------------------------------*\
    *****************AntibanEnd*****************
    /*----------------------------------------*/

    /*----------------------------------------*\
    *******************Skills*******************
    /*----------------------------------------*/

    //Antiban method that checks the prayer tab
    public void checkPraySkill() {
        //----------------------------------Done---------------------------------------//
        //switch statement to determine whether to click the prayer tab or to check the prayer skill. Only one or the other
        int prayRandomizer = Random.nextInt(1,2);
        switch (prayRandomizer){
            default:
                break;
            case 1:
                // Opens Prayer Tab
                widgetBuilder(161,56);
                //Clicks on thick skin
                //4 - 32 works for prayers ..541,1-32
                //Randomly clicks on a prayer in the prayer tab
                widgetBuilder(541,Random.nextInt(1,32),400,700);
        }

        //Checks to see if screen with skill tabs is open, if not:
        if (!ctx.widgets.component(320, 0).inViewport()) {
            //Opens Skills Tab
            widgetBuilder(161,52,1200,1500);
        }

        Condition.sleep(org.powerbot.script.Random.nextInt(500, 7000));
        //Prayer Skill Tab 1-5
        ctx.widgets.component(320, 5).hover();
        ctx.widgets.component(320, 5).click();
        Condition.sleep(org.powerbot.script.Random.nextInt(980, 1205));
        //Prayer Screen 11-prayers, 12-Equipment, 13-Other
        ctx.widgets.component(214,12).click();
        Condition.sleep(org.powerbot.script.Random.nextInt(1000, 1300));
        //Exits Prayer Screen
        ctx.widgets.component(214,25).click();
    }// End of checkPraySkill Function

    public void checkMagic() {
        //----------------------------------Done---------------------------------------//
        //Opens Skills Tab
        ctx.game.tab(Game.Tab.STATS);
        //widgetBuilder(161,52,1200,1500);

        //Hovers and Clicks on Magic Skill
        widgetBuilder(320,6,1100,1800);
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1000));

        //Clicks between 11-Normal Spells, 12-Ancient Magicks, 13-Lunar Spells, 14-Arceus Spells, 15-Armour, 16-Weapons, 17-Equipment, 18-Salamanders
        widgetBuilder(214,Random.nextInt(11,19),800,1400);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHerb() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the herb skill
        widgetBuilder(320,6,1200,2000); //Does not have the correct widget
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1000));

        //Clicks between 11-Potions, 12-Herbs, 13-Barbarian Potions, 14-Raids, 15-Other
        widgetBuilder(214,Random.nextInt(11,15),750,1500);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFish() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks over the skill
        widgetBuilder(320,19,1000,1500);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Catches, 12-Barbarian, 13- Equipment, 14-Raids, 15-Other
        widgetBuilder(214,Random.nextInt(11,15),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkSlayer() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the slayer skill
        widgetBuilder(320,15,1150,1890);
        Condition.sleep(org.powerbot.script.Random.nextInt(1300,1600));

        //Clicks between 11-Monsters, 12-Equipment, 13- Slayer Masters
        widgetBuilder(214,Random.nextInt(11,13),550,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkSmithing() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on the smithing skill
        widgetBuilder(320,18,1230,1670);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1640));

        //Clicks between 11-Burning, 12-Barbarian, 13-Equipment
        widgetBuilder(214,Random.nextInt(11,13),600,1100);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }
    public void checkkFiremaking() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on firemaking skill
        widgetBuilder(320,21,1345,1832);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Smelting, 12-Bronze, 13-Blurite, 14-Iron, 15-Steel, 16-Mithril, 17-Adamant, 18-Rune, 19-Lovakite, 20-Other
        widgetBuilder(214,Random.nextInt(11,20),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHitpoints() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on  hitpoints skill
        widgetBuilder(320,9,1425,1912);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Hitpoints, 12-Healing, 13-Equipment
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkRange() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Cliciks on range skill
        widgetBuilder(320,4,1201,1502);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Bows, 12-Thrown, 13-Crossbows, 14-Armour, 15-Miscellaneous, 16-Shortcuts, 17-Salamanders
        widgetBuilder(214,Random.nextInt(11,27),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();


    }

    public void checkMining() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers over the skill
        widgetBuilder(320,17,1123,1560);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Rocks, 12-Equipment
        widgetBuilder(214,Random.nextInt(11,12),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkRunecrafting() {
        //-------------------------Done---------------------
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers over the Runecrafting skill 7.1-4
        //Clicks on a specific location within Runecrafting skill tab
        //widgetBuilder(320,7,1,300,800);
        widgetBuilder(320,7,300,800);
        Condition.sleep(org.powerbot.script.Random.nextInt(600,800));

        //Runecrafting Screen 11-Runes, 12-Multiple Runes, 13-Rune Pouches, 14- Infusing
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();

        //Click the skill and scrolls to the bottom
        //Clicks on option(Switch)
    }

    public void checkAttack(){
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on attack skill
        widgetBuilder(320,1,1204,1553);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weapons, 12-Armour, 13-Salamanders
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkStrength() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on strength skill
        widgetBuilder(320,2,1049,1494);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weapons, 12-Armour, 13-Shortcuts, 14-Areas, 15-Barbarian
        widgetBuilder(214,Random.nextInt(11,15),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkDefence() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks defence skill
        widgetBuilder(320,3, 1190,1489);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Armour, 12-Penance, 13-Prayers, 14-Shields
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkAgility() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks agility skill
        widgetBuilder(320,10,1049,1645);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Courses, 12-Areas, 13-Shortcuts, 14-Barbarian
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkWoodCutting() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks woodcutting skill
        widgetBuilder(320,22,931,1323);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Trees, 12-Axes, 13-Other
        widgetBuilder(214,Random.nextInt(11,13),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkThieving() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on thieving skill
        widgetBuilder(320,12,849,1920);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Picketpocket, 12-Stalls, 13-Chests, 14-Other
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkCrafting() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on crafting skill
        widgetBuilder(320,13,938,1230);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Weaving, 12-Armour, 13-Spinning, 14-Pottery, 15-Glass, 16-Jewellery, 17-Weaponry, 18-Other
        widgetBuilder(214,Random.nextInt(11,18),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFletching() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on fletching skill
        widgetBuilder(320,14,1202,1402);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Picketpocket, 12-Stalls, 13-Chests, 14-Other
        widgetBuilder(214,Random.nextInt(11,14),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkHunter() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on hunter skill
        widgetBuilder(320,16,879,1903);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Tracking, 12-Birds, 13-Butterflies, 14-Implings, 15-Deadfall, 16-Box Trap, 17-Net Trap, 18-Pitfalls, 19-Falconry, 20-Traps, 21-Clothing, 22-Raids, 23-Birdhouses, 24-Other
        widgetBuilder(214,Random.nextInt(11,24),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkCooking() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on cooking skill
        widgetBuilder(320,20,1230,1780);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Meats, 12-Bread, 13-Pies, 14-Stews, 15-Pizzas, 16-Cakes, 17-Wine, 18-Hot Drinks, 19-Brewing, 20-Vegetable, 21-Dairy, 22-Gnome, 23-Raids
        widgetBuilder(214,Random.nextInt(11,23),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkFarming() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on farming skill
        widgetBuilder(320,23,948,1934);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Allotments, 12-Hops, 13-Trees, 14-Fruit Trees, 15-Bushes, 16-Flowers, 17-Herbs, 18-Special, 19-Scarecrows, 20-Multiple Roots, 21-Tithe Farm, 22-Raids
        widgetBuilder(214,Random.nextInt(11,22),600,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkConstruction() {
        //----------------------------------Done---------------------------------------//
        //Open the skills tab
        ctx.game.tab(Game.Tab.STATS);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,500));

        //Hovers and Clicks on construction skill
        widgetBuilder(320,8,1300,1714);
        Condition.sleep(org.powerbot.script.Random.nextInt(1000,1500));

        //Clicks between 11-Rooms, 12-Skills, 13-Surfaces, 14-Storage, 15-Decorative, 16-Trophies, 17-Games, 18-Garden, 19-Dungeon, 20-Chapel, 21-Raids, 22-Other, 23-Servants, 24-House Size
        widgetBuilder(214,Random.nextInt(11,22),900,1200);
        Condition.sleep(org.powerbot.script.Random.nextInt(300,600));

        //Closes screen
        ctx.widgets.component(214,25).click();
    }

    public void checkTotal() {
        //--------------------------Done--------------------
        ctx.widgets.component(320,Random.nextInt(24,27)).hover();
        Condition.sleep(org.powerbot.script.Random.nextInt(800,1100));
    }

    /*----------------------------------------*\
    ******************SkillsEnd*****************
    /*----------------------------------------*/

    /*----------------------------------------*\
    *******************Misc*********************
    /*----------------------------------------*/

    public void speak(){
        //--------------Done--------------
        switch(randomizerThirty) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(500, 900));
                break;
            case 1:
                ctx.chat.sendInput("Hey");
                break;
            case 2:
                ctx.chat.sendInput("Kill me");
                break;
            case 3:
                ctx.chat.sendInput("This is tiring");
                break;
            case 4:
                ctx.chat.sendInput("Cheese Potato");
                break;
            case 5:
                ctx.chat.sendInput("Rotel Dip");
                break;
            case 6:
                ctx.chat.sendInput("Poop Stain");
                break;
            case 7:
                ctx.chat.sendInput("Bropotato");
                break;
        }//End of switch statement
    }//End of speak function

    public void run(){
        widgetBuilder(160,Random.nextInt(21,27));
    }

    public void checkFriendsList(){
        //----------------------Done--------------
        //Determines how to open the smiley tab
        switch(randomizerFive){
            default:
                //Method for opening friends tab
                ctx.game.tab(Game.Tab.FRIENDS_LIST);
                break;
            case 1:
                //Widget for friends Tab
                widgetBuilder(161,36,400,700);
                break;
            case 2:
                //Widget for friends Tab 2
                widgetBuilder(161,43,400,700);
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(1200,1800));

        switch(randomizerThirty) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));
                break;
            case 1:
                //Widget for add friend
                widgetBuilder(429,Random.nextInt(11,12));
                break;
            case 2:
                //Widget for delete friend
                widgetBuilder(429,Random.nextInt(13,14));
                break;
        }
        //Click on add friend
        //Add a random name
        //Created function to randomly generate numbers, convert them to strings and concatenate
        //name it name generator -- only generates numbers with numbers
        //Clicks on remove friend
        //Removes random name
        //Attempts to remove random name even if it doesnt exist on friends list
    }

    public void checkIgnoreList() {
        //Determines how to open the frowny tab
        switch(randomizerFive){
            default:
                //Method for opening friends tab
                ctx.game.tab(Game.Tab.IGNORED_LIST);
                break;
            case 1:
                //Widget for Ignore Tab
                widgetBuilder(161,37,400,700);
                break;
            case 2:
                //Widget for Ignore Tab 2
                widgetBuilder(161,44,400,700);
        }
        switch(randomizerThirty) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));
                break;
            case 1:
                //Add Name
                widgetBuilder(432,Random.nextInt(10,11));
                break;
            case 2:
                //Remove Name
                widgetBuilder(432,Random.nextInt(12,13));
                break;

        }
    }

    public void checkEquipment(){
        //-----------------Completed, Needs to close screens-----------------
        //Opens equipment tab
        ctx.game.tab(Game.Tab.EQUIPMENT);
        Condition.sleep(org.powerbot.script.Random.nextInt(950,1500));

        //Selects and clicks equipment tab
        //widgetBuilder(161,55);

        switch(randomizerFifteen) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1834,2103));
                break;
            case 1:
                //Selects and clicks price checker
                widgetBuilder(387,20);
                Condition.sleep(org.powerbot.script.Random.nextInt(1650,1900));
                //Adds all to Price checker for price check
                widgetBuilder(464,10);
                Condition.sleep(org.powerbot.script.Random.nextInt(1500,1900));
                //Closes out of screen
                widgetBuilder(464,1,11,300,500);
                break;
            case 2:
                //Checks items kept on death
                widgetBuilder(387,21);
                //Closes out of screen
                widgetBuilder(4,13,400,700);
                break;
            case 3:
                //Checks current armor worn
                widgetBuilder(387,Random.nextInt(17,18));
                //Closes out of screen
                widgetBuilder(84,4,400,700);
                break;
            case 4:
                //Clicks call follower
                widgetBuilder(387,Random.nextInt(23,24));
                break;
        }
    }

    public void xpAlter() {
        //------------------------Done------------------
        //Hovers and clicks on xp counter
        widgetBuilder(160,1);
        Condition.sleep(org.powerbot.script.Random.nextInt(810, 1510));
    }

    public void checkClanChat(){
        //Selects clan chat tab
        ctx.game.tab(Game.Tab.CLAN_CHAT);

//        //Widget for clanchat
//        widgetBuilder(161,35);

        //Selects option to either leave or join a clan
        switch (randomizerThirty){
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1000,2500));
                break;
            case 1:
                //Widget that clicks on join/leave chat in cc
                widgetBuilder(7,17);
                break;
            case 2:
                //Widget for clan setup
                widgetBuilder(7,Random.nextInt(18,19));
                break;
        }
    }

    public void checkCombatStyle() {
        //-----------------------------Done--------------
        //Selects an attack style from the combat style menu
        switch(randomizerFive){
            default:
                //Clicks Accuate
                widgetBuilder(593,Random.nextInt(3,6));
                break;
            case 1:
                //Click rapid
                widgetBuilder(593,Random.nextInt(7,9));
                break;
            case 2:
                //Click longrange
                widgetBuilder(593,Random.nextInt(11,18));
                break;
            case 3:
                //Click Autoretaliate
                widgetBuilder(593,Random.nextInt(27,28));
                break;
            case 4:
                Condition.sleep(org.powerbot.script.Random.nextInt(1670,1982));
                break;
        }
    }

    public void checkMusic(){
        //-------------------Completed, Not Done----------------
        //click on tab
        ctx.game.tab(Game.Tab.MUSIC);

//        //widget for music
//        widgetBuilder(161,41);

        //change the song

        //Clicks the down arrow to scroll in music tab
        widgetBuilder(239,4,5,2100,2500);

        //Clicks the up arrow to scroll in music tab
        widgetBuilder(239,4,5,2100,2500);
//
//        //Clicks the manual button on music tab
//        widgetBuilder(239,10,200,400);
//
//        //Clicks the auto button on music tab
//        widgetBuilder(239,8,200,400);
//
//        //Clicks different part of the loop button on music tab
//        widgetBuilder(239,Random.nextInt(11,12),200,400);
    }

    public void checkChatOptions() {
        //----------------------------------Done----------------------------------
        switch(randomizerFifteen) {
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(1143,1910));
                break;
            case 1:
                //All
                widgetBuilder(162,Random.nextInt(3,5),200,400);
                break;
            case 2:
                //Game
                widgetBuilder(162,Random.nextInt(6,9),200,400);
                break;
            case 3:
                //Public
                widgetBuilder(162,Random.nextInt(10,13),200,400);
                break;
            case 4:
                //Private
                widgetBuilder(162,Random.nextInt(14,17),200,400);
                break;
            case 5:
                //Clan
                widgetBuilder(162,Random.nextInt(18,21),200,400);
                break;
            case 6:
                //Trade
                widgetBuilder(162,Random.nextInt(22,25),200,400);
                break;
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(950,1150));
        //Report
        //widgetBuilder(162,Random.nextInt(26,28),200,400);

    }

    public void checkQuest() {
        //-----------------Completed, not Done-----------
        //Opens Quest tab
        ctx.game.tab(Game.Tab.QUESTS);

        //Randomly selects one of the 116 quests to click on
        widgetBuilder(399,8,Random.nextInt(0,115));

        //Closes quest screen
        widgetBuilder(275,134,500,1000);
    }

    public void checkQuickPray() {
        //-------------------Done------------
        //Clicks on the quick prayer button
        widgetBuilder(160,Random.nextInt(14,19),700,1000);
    }

    public void checkInventory() {
        //-----------------Done---------------------------
        //Determines how to open the Inventory tab
        switch(randomizerFive){
            default:
                //Method for opening Inventory Tab
                ctx.game.tab(Game.Tab.INVENTORY);
                break;
            case 1:
                //Widget for Inventory Tab2
                widgetBuilder(161,54,400,700);
                break;
            case 2:
                //Widget for Inventory Tab 3
                widgetBuilder(161,61,400,700);
        }
        Condition.sleep(org.powerbot.script.Random.nextInt(1750,2750));
    }

    public void checkLogout() {
        //-----------------Complete, not Done----------------------
        //Opens Logout tab
        ctx.game.tab(Game.Tab.LOGOUT);
        Condition.sleep(org.powerbot.script.Random.nextInt(1100,1834));

        //Switch Worlds

        //Logout

        //Widget for logout tab
        //widgetBuilder(161,38);
    }

    public void checkWorldMap() {
        //---------------Complete, not Done-------------------------00
        //Opens the world map
        widgetBuilder(28,29);
        Condition.sleep(org.powerbot.script.Random.nextInt(1450,1980));
        //Closes the world map
        widgetBuilder(595,34);

        /*
        //Shows Clue Scroll Overview
        widgetBuilder(595,25);

        //Zooms in on the map
        widgetBuilder(595,24);

        //Zooms out of the map
        widgetBuilder(595,23);

        //Chooses which view on Runescape to display on the map
        widgetBuilder(595,22,Random.nextInt(0,4),200,200);
        */
    }

    public void checkSettings() {
        //---------------------Done-------------------------
        //Opens Options Tab
        ctx.game.tab(Game.Tab.OPTIONS);

        //Chooses what to select once at the options tab
        switch(randomizerThirty){
            default:
                Condition.sleep(org.powerbot.script.Random.nextInt(2000,3300));
                break;
            case 1:
                //Fixed Mode
                widgetBuilder(261,19);
                break;
            case 2:
                //Run Energy
                widgetBuilder(261,Random.nextInt(74,76));
                break;
            case 3:
                //House Options
                widgetBuilder(261,Random.nextInt(77,78));
                break;
            case 4:
                //Old School Bonds
                widgetBuilder(261,Random.nextInt(79,80));
                break;
            case 5:
                //0,1-Display --- 2,3-Audio --- 3,4-Chat --- 5,6-Controls
                widgetBuilder(261,1,Random.nextInt(0,7),600,800);
                break;
            case 6:
                //Accept Aid
                widgetBuilder(261,Random.nextInt(72,73));
                break;
            case 7:
                //Advanced Options
                widgetBuilder(261,21);
                break;
            case 99:
                //Expand game
                widgetBuilder(261,20);
                break;
        }
    }

    public void checkSpells() {
        //---------------------------Done--------------
        //Opens the magic game tab
        ctx.game.tab(Game.Tab.MAGIC);
        Condition.sleep(org.powerbot.script.Random.nextInt(1600,2500));
    }

    /*----------------------------------------*\
    *******************End Misc*****************
    /*----------------------------------------*/

    /*----------------------------------------*\
    *******************Widgets******************
    /*----------------------------------------*/

    //Widget builder that creates, hovers, and clicks widgets
    public void widgetBuilder(int x, int y) {
        ctx.widgets.component(x,y).hover();
        ctx.widgets.component(x,y).click();
    }

    //Widget builder than handles subcomponents within widgets; creates, hovers, and clicks widegets
    public void widgetBuilder(int x, int y, int z) {
        ctx.widgets.component(x,y).component(z).hover();
        ctx.widgets.component(x,y).component(z).click();
    }

    //Widget builder that creates, hovers, and clicks widgets, but pauses between hovering and clicking
    public void widgetBuilder(int x, int y, int min, int max) {
        ctx.widgets.component(x,y).hover();
        Condition.sleep(org.powerbot.script.Random.nextInt(min,max));
        ctx.widgets.component(x,y).click();
    }
    //Widget builder with subcomponents that creates, hovers, and clicks widgets, but pauses between hovering and clicking
    public void widgetBuilder(int x, int y, int z, int min, int max) {
        ctx.widgets.component(x,y).component(z).hover();
        Condition.sleep(org.powerbot.script.Random.nextInt(min,max));
        ctx.widgets.component(x,y).component(z).click();
    }

    /*----------------------------------------*\
    *****************End Widgets****************
    /*----------------------------------------*/

    @Override
    public boolean activate() {
        if (Random.nextInt(0, 99) == 50) {
            if (Random.nextInt(0, 15) == 3) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void execute() {
        antiban(0,0);
    }
}
