package com.training.questions.provider;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuestionsCountProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider, Serializable {
    private FieldNameProvider fieldNameProvider;

    @Override
    public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
                                                 final Object obj) throws FieldValueProviderException {
        if (obj instanceof ProductModel) {
            ProductModel product = (ProductModel) obj;
            List<FieldValue> fieldValues = createFieldValue(product, indexConfig, indexedProperty);
            return fieldValues;
        } else {
            throw new FieldValueProviderException("Cannot get questionsCount for a product model");
        }
    }

    private List<FieldValue> createFieldValue(ProductModel product, IndexConfig indexConfig, IndexedProperty indexedProperty) throws FieldValueProviderException {
        List<FieldValue> fieldValues = new ArrayList<>();
        Integer questionsCount = product.getQuestionsCount();
        if (questionsCount != null) {
            addFieldValues(fieldValues, indexedProperty, null, questionsCount);
        }
        return fieldValues;
    }

    private void addFieldValues(List<FieldValue> fieldValues, IndexedProperty indexedProperty, LanguageModel language, Object value) throws FieldValueProviderException {
        List<String> rangeNameList;
        try {
            rangeNameList = getRangeNameList(indexedProperty, value, "questionsCount");
        } catch (FieldValueProviderException e) {
            throw new FieldValueProviderException("Cannot get range for property [" + indexedProperty.getName() + "] with value [" + value + "]", e);
        }
        Collection<String> fieldNames = fieldNameProvider.getFieldNames(indexedProperty, (language == null) ? null : language.getIsocode());
//        rangeNameList.forEach(rangeName -> fieldNames.forEach(
//                fieldName -> fieldValues.add(new FieldValue(fieldName, rangeName == null ? value : rangeName))
//        ));
//        for (String rangeName : rangeNameList) {
//            for (String fieldName : fieldNames) {
//                fieldValues.add(new FieldValue(fieldName, rangeName == null ? value : rangeName));
//            }
//        }
        String rangeName = null;
        if (CollectionUtils.isNotEmpty(rangeNameList)) {
            rangeName = rangeNameList.get(0);
        }
        final Object valueToPass = (rangeName == null ? value : rangeName);
        for (final String fieldName : fieldNames) {
            fieldValues.add(new FieldValue(fieldName, valueToPass));
        }
    }

    @Required
    public void setFieldNameProvider(FieldNameProvider fieldNameProvider) {
        this.fieldNameProvider = fieldNameProvider;
    }
}
