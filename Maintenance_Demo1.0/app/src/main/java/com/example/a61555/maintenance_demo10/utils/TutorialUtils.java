package com.example.a61555.maintenance_demo10.utils;

import android.content.Context;
import com.example.a61555.maintenance_demo10.R;
import java.util.ArrayList;
import za.co.riggaroo.materialhelptutorial.TutorialItem;

public class TutorialUtils {

    public static ArrayList<TutorialItem> getTutorialItems(Context context) {
        TutorialItem tutorialItem1 = new TutorialItem(R.string.slide_1_title, R.string.slide_1_details,
                R.color.slide_1, R.drawable.tut_page_1_front,  R.drawable.tut_page_1_background);

        TutorialItem tutorialItem2 = new TutorialItem(R.string.slide_2_title, R.string.slide_2_details,
                R.color.slide_2,  R.drawable.tut_page_2_front,  R.drawable.tut_page_2_background);

        TutorialItem tutorialItem3 = new TutorialItem(R.string.slide_3_title, R.string.slide_3_details,
                R.color.slide_3, R.drawable.tut_page_3_foreground, R.drawable.tut_page_2_background);

        TutorialItem tutorialItem4 = new TutorialItem(R.string.slide_4_title, R.string.slide_4_details,
                R.color.slide_4,  R.drawable.tut_page_4_foreground, R.drawable.tut_page_4_background);

        ArrayList<TutorialItem> tutorialItems = new ArrayList<>();
        tutorialItems.add(tutorialItem1);
        tutorialItems.add(tutorialItem2);
        tutorialItems.add(tutorialItem3);
        tutorialItems.add(tutorialItem4);

        return tutorialItems;
    }
}
