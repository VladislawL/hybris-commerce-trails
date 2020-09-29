package com.training.questions.controllers.cms;

import com.training.questions.controllers.QuestionsControllerConstants;
import com.training.questions.model.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.QuestionsCMSComponent)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        model.addAttribute("numberOfQuestionsToShow", component.getNumberOfQuestionsToShow());
        model.addAttribute("fontSize", component.getFontSize());
    }
}
