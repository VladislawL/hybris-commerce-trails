package com.training.questions.attributehandlers;

import com.training.questions.model.QuestionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;

import java.util.Set;

public class QuestionsCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {

    @Override
    public Integer get(ProductModel productModel) {
        Set<QuestionModel> questions = productModel.getQuestions();
        if (questions == null) {
            return 0;
        }
        return questions.size();
    }

}
