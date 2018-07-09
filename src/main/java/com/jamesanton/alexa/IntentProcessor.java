package com.jamesanton.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IntentProcessor {

    Map<String, String> intentInOut = new HashMap<String, String>() {{
        put("onCallThisWeek", "One of the developers is on call this week.");
        put("onCallNextWeek", "Someone else is on call next week.");
        put("onCallSep302018", "Not me.");
    }};

    public SpeechletResponse processIntent(Intent intent) {
        String intentName = intent.getName();
        SpeechletResponse response = new SpeechletResponse();
        response.setOutputSpeech(new PlainTextOutputSpeech(){{
            setText(intentInOut.get(intentName));
        }});
        return response;
    }

}
