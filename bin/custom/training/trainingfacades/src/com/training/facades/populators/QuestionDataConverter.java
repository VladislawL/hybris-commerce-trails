package com.training.facades.populators;

import com.training.questions.data.QuestionData;
import com.training.questions.model.QuestionModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.dto.converter.Converter;

public class QuestionDataConverter implements Converter<QuestionModel, QuestionData> {

    @Override
    public QuestionData convert(QuestionModel questionModel) throws ConversionException {
        QuestionData questionData = new QuestionData();
        questionData.setCode(questionModel.getCode());
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setQuestionCustomer(questionModel.getQuestionCustomer().getDisplayName());
        questionData.setAnswer(questionModel.getAnswer());
        questionData.setAnswerCustomer(questionModel.getAnswerCustomer().getDisplayName());
        return questionData;
    }

    @Override
    public QuestionData convert(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
        questionData.setCode(questionModel.getCode());
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setQuestionCustomer(questionModel.getQuestionCustomer().getDisplayName());
        questionData.setAnswer(questionModel.getAnswer());
        questionData.setAnswerCustomer(questionModel.getAnswerCustomer().getDisplayName());
        return questionData;
    }
}
