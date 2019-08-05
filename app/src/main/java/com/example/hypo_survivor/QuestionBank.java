package com.example.hypo_survivor;

// This class contains a list of questions
import android.content.Context;

import com.example.hypo_survivor.MyDataBaseHelper;
import com.example.hypo_survivor.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // declare list of Question objects
    List<Question> list = new ArrayList<>();
    MyDataBaseHelper myDataBaseHelper;

    // method returns number of questions in list
    public int getLength(){
        return list.size();
    }

    // method returns question from list based on list index
    public String getQuestion(int a) {
        return list.get(a).getQuestion();
    }

    // method return a single multiple choice item for question based on list index,
    // based on number of multiple choice item in the list - 1, 2, 3 or 4
    // as an argument
    public String getChoice(int index, int num) {
        return list.get(index).getChoice(num-1);
    }

    //  method returns correct answer for the question based on list index
    public String getCorrectAnswer(int a) {
        return list.get(a).getAnswer();
    }



    public void initQuestions(Context context) {
        myDataBaseHelper = new MyDataBaseHelper(context);
        list = myDataBaseHelper.getAllQuestionsList();//get questions/choices/answers from database

        if (list.isEmpty()) {//if list is empty, populate database with default questions/choices/answers
            myDataBaseHelper.addInitialQuestion(new Question("1. You wake up and realize you are in the middle of the wilderness. Your cell phone is broken and you have very little supplies. At this moment, your mentality should be?",
                    new String[]{"A. Frantic and sporadic.", "B. Hopeful to be rescued.", "C. Panicked and distressed.", "D. Focused and positive."}, "D. Focused and positive."));
            myDataBaseHelper.addInitialQuestion(new Question("2. Insects are a great source of protein and would be a good choice to eat. Not all insects are good to eat. You come across several types of insects, which one do you choose?",
                    new String[]{"A. Wasps.", "B. Grasshoppers.", "C. Fuzzy, green caterpillars.", "D. Brightly colored bugs."}, "B. Grasshoppers."));
            myDataBaseHelper.addInitialQuestion(new Question("3. You are walking along a path when you come across what looks like a snake with black, yellow, and red bands along its body. After closely inspecting it, you notice the red bands are in between yellow. This snake is small but it could be good to eat. What do you do?",
                    new String[]{"A. Jump at it like Steve Irwin and yell CRICKY!.", "B. Grab it by the tail.", "C. Leave it alone and move on.", "D. Follow it to see if it might have eggs at its nest."}, "C. Leave it alone and move on."));
            myDataBaseHelper.addInitialQuestion(new Question("4. You are extremely hungry and manage to come to a clearing with various plants and mushrooms. A lot of what you see looks pretty edible, what would you choose?",
                    new String[]{"A. Wild mushrooms near a tree.", "B. A pink/magenta colored plant with dark purple berries.", "C. White berries with a black dot on magenta colored stalks.", "D. A fern with fiddle-shapes."}, "D. A fern with fiddle-shapes."));
            myDataBaseHelper.addInitialQuestion(new Question("5. It’s getting dark and you are getting cold. You want to start a fire to keep yourself warm. How will you get a fire started?",
                    new String[]{"A. Create a bow from green wood, a drill from hardwood, and a board with softwood.", "B. Create a bow from softwood, a drill from greenwood, and a board from hardwood.", "C. Rub two sticks together.", "D. Create a bow from hardwood, a drill from softwood, and a board from green wood."}, "A. Create a bow from green wood, a drill from hardwood, and a board with softwood."));
            myDataBaseHelper.addInitialQuestion(new Question("6. You are gathering materials for your night ahead of camping when you accidentally cut your hand. It’s not a terribly deep wound but you don’t know how much bacteria is on the object that cut you. What would be the best way to ensure your wound does not get infected?",
                    new String[]{"A. Thoroughly clean the skin around the wound by rinsing it with water or fresh urine then dress it with a clean bandage or cloth.", "B. Dress it immediately with a bandage or cloth.", "C. Clean the wound and skin with the closest puddle of water that you can find then dress with a clean bandage or cloth.", "D. Leave the wound open."}, "A. Thoroughly clean the skin around the wound by rinsing it with water or fresh urine then dress it with a clean bandage or cloth."));
            myDataBaseHelper.addInitialQuestion(new Question("7. You are looking for twigs and branches around your campsite.  You gather a nice bunch and head back towards the fire.  You do not notice a rock by your foot and trip over it.  The kindling you found flies out of your arms and your hand lands into the coals.  How do you treat your burn?",
                    new String[]{"A. Pour cool water on it and leave it alone.", "B. Pour cool water on it. Soak dressing in boiling tannic acid solution for ten minutes. Let the dressings cool then place on the burn.", "C. Stick your hand in water for ten minutes. Soak dressing in cool water then wrap around the burn.", "D. Pour cool water on it then shake it like a Polaroid picture."}, "B. Pour cool water on it. Soak dressing in boiling tannic acid solution for ten minutes. Let the dressings cool then place on the burn."));
            myDataBaseHelper.addInitialQuestion(new Question("8. You make to a river and want to cross it. You get to higher ground and see various parts of the river. How will you cross?",
                    new String[]{"A. Jump right in and cross it.", "B. Cross it where the river breaks into smaller channels.", "C. Cross the wide estuary of the river.", "D. Rocky areas so you can have a place for footing."}, "B. Cross it where the river breaks into smaller channels."));
            myDataBaseHelper.addInitialQuestion(new Question("9. You are walking a trail, searching for food when suddenly you hear a growl. You turn around and notice a cougar. What do you do?",
                    new String[]{"A. Play dead.", "B. Fight back.", "C. Try to reason with it.", "D. Run away."}, "B. Fight back."));
            myDataBaseHelper.addInitialQuestion(new Question("10. You’ve been hearing helicopters in the distance.  This might be the perfect opportunity to signal them, how do you proceed?",
                    new String[]{"A. Strip down naked and make a flag to wave around.", "B. Create the letters SOS out of white stones.", "C. Make a triangle out of three fires.", "D. Make a line out of four fires."}, "C. Make a triangle out of three fires."));

            list = myDataBaseHelper.getAllQuestionsList();//get list from database again

        }
    }

}