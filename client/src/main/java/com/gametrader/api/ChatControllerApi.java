package com.gametrader.api;

import com.gametrader.api.invoker.ApiClient;

import com.gametrader.api.model.ConversationDto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-06-10T09:32:19.507264800+02:00[Europe/Belgrade]")
@Component("com.gametrader.api.ChatControllerApi")
public class ChatControllerApi {
    private ApiClient apiClient;

    public ChatControllerApi() {
        this(new ApiClient());
    }

    @Autowired
    public ChatControllerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param conversationDto  (required)
     * @return ConversationDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ConversationDto createConversation(ConversationDto conversationDto) throws RestClientException {
        return createConversationWithHttpInfo(conversationDto).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param conversationDto  (required)
     * @return ResponseEntity&lt;ConversationDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ConversationDto> createConversationWithHttpInfo(ConversationDto conversationDto) throws RestClientException {
        Object postBody = conversationDto;
        
        // verify the required parameter 'conversationDto' is set
        if (conversationDto == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'conversationDto' when calling createConversation");
        }
        

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<ConversationDto> returnType = new ParameterizedTypeReference<ConversationDto>() {};
        return apiClient.invokeAPI("/v1/message/create", HttpMethod.POST, Collections.<String, Object>emptyMap(), queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param id  (required)
     * @return ConversationDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ConversationDto getConversationById(Long id) throws RestClientException {
        return getConversationByIdWithHttpInfo(id).getBody();
    }

    /**
     * 
     * 
     * <p><b>200</b> - OK
     * @param id  (required)
     * @return ResponseEntity&lt;ConversationDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ConversationDto> getConversationByIdWithHttpInfo(Long id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling getConversationById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, String> cookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "*/*"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] contentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<ConversationDto> returnType = new ParameterizedTypeReference<ConversationDto>() {};
        return apiClient.invokeAPI("/v1/message/get/{id}", HttpMethod.GET, uriVariables, queryParams, postBody, headerParams, cookieParams, formParams, localVarAccept, localVarContentType, authNames, returnType);
    }
}
