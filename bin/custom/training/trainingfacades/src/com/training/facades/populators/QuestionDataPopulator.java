package com.training.facades.populators;

import com.training.questions.data.QuestionData;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.springframework.beans.factory.annotation.Required;

import java.util.ArrayList;
import java.util.List;

public class QuestionDataPopulator implements Populator<ProductModel, ProductData> {

    private QuestionDataConverter questionDataConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        List<QuestionData> questions = new ArrayList<>();
        productModel.getQuestions().forEach(p -> questions.add(questionDataConverter.convert(p)));
        productData.setQuestions(questions);
    }

    @Required
    public void setQuestionDataConverter(QuestionDataConverter questionConverter) {
        this.questionDataConverter = questionConverter;
    }
}
