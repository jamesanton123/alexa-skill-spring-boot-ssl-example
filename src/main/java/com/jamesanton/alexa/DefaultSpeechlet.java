package com.jamesanton.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultSpeechlet implements Speechlet {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultSpeechlet.class);

    @Override
    public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
        LOG.info("Session started");
    }

    @Override
    public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        return null;
    }

    @Override
    public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        LOG.info("intent received: " + request.getIntent().getName());
        Intent intent = request.getIntent();
        if (intent == null)
            throw new SpeechletException("Unrecognized intent");

        String intentName = intent.getName();
        SpeechletResponse response = new SpeechletResponse();
        response.setOutputSpeech(new PlainTextOutputSpeech(){{
            setText("This is some example alexa output");
        }});
        return response;
    }

    @Override
    public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

    }

}
