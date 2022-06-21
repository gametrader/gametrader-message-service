# ChatControllerApi

All URIs are relative to *http://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createConversation**](ChatControllerApi.md#createConversation) | **POST** /v1/message/create | 
[**getConversationById**](ChatControllerApi.md#getConversationById) | **GET** /v1/message/get/{id} | 



## createConversation

> ConversationDto createConversation(conversationDto)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.ChatControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ChatControllerApi apiInstance = new ChatControllerApi(defaultClient);
        ConversationDto conversationDto = new ConversationDto(); // ConversationDto | 
        try {
            ConversationDto result = apiInstance.createConversation(conversationDto);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#createConversation");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **conversationDto** | [**ConversationDto**](ConversationDto.md)|  |

### Return type

[**ConversationDto**](ConversationDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |


## getConversationById

> ConversationDto getConversationById(id)



### Example

```java
// Import classes:
import com.gametrader.api.invoker.ApiClient;
import com.gametrader.api.invoker.ApiException;
import com.gametrader.api.invoker.Configuration;
import com.gametrader.api.invoker.models.*;
import com.gametrader.api.ChatControllerApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("http://localhost:8080");

        ChatControllerApi apiInstance = new ChatControllerApi(defaultClient);
        Long id = 56L; // Long | 
        try {
            ConversationDto result = apiInstance.getConversationById(id);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ChatControllerApi#getConversationById");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Long**|  |

### Return type

[**ConversationDto**](ConversationDto.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | OK |  -  |

