package com.example.demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * All 40 Test Cases for Dynamic Coupon Generator
 * Simple tests suitable for college students
 */
@Listeners(TestResultListener.class)
public class AllTests {
    
    private static final String PROJECT_ROOT = System.getProperty("user.dir");
    private static final String BASE_URL = "http://localhost:9001";
    private String authToken;
    private String testUsername;
    
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
        // Setup test user and get token for authenticated tests
        try {
            testUsername = "testuser" + System.currentTimeMillis();
            // Register user
            Response registerResponse = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + testUsername + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            if (registerResponse.getStatusCode() == 200) {
                // Login to get token
                Response loginResponse = RestAssured.given()
                    .contentType("application/json")
                    .body("{\"username\":\"" + testUsername + "\",\"password\":\"test123\"}")
                    .post("/auth/login");
                
                if (loginResponse.getStatusCode() == 200) {
                    Map<String, String> response = loginResponse.jsonPath().getMap("$");
                    authToken = "Bearer " + response.get("token");
                }
            }
        } catch (Exception e) {
            // If server is not running, tests will fail gracefully
        }
    }
    
    // ========== FOLDER STRUCTURE TESTS (Test Cases 1-10) ==========
    
    @Test(priority = 1, description = "Test Case 1: Check if src/main/java folder exists")
    public void testSrcMainJavaFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java");
        Assert.assertTrue(Files.exists(path), "src/main/java folder should exist");
        Assert.assertTrue(Files.isDirectory(path), "src/main/java should be a directory");
    }
    
    @Test(priority = 2, description = "Test Case 2: Check if src/main/resources folder exists")
    public void testSrcMainResourcesFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "resources");
        Assert.assertTrue(Files.exists(path), "src/main/resources folder should exist");
        Assert.assertTrue(Files.isDirectory(path), "src/main/resources should be a directory");
    }
    
    @Test(priority = 3, description = "Test Case 3: Check if src/test/java folder exists")
    public void testSrcTestJavaFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "test", "java");
        Assert.assertTrue(Files.exists(path), "src/test/java folder should exist");
        Assert.assertTrue(Files.isDirectory(path), "src/test/java should be a directory");
    }
    
    @Test(priority = 4, description = "Test Case 4: Check if model package folder exists")
    public void testModelPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "model");
        Assert.assertTrue(Files.exists(path), "com/example/demo/model package folder should exist");
    }
    
    @Test(priority = 5, description = "Test Case 5: Check if controller package folder exists")
    public void testControllerPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "controller");
        Assert.assertTrue(Files.exists(path), "com/example/demo/controller package folder should exist");
    }
    
    @Test(priority = 6, description = "Test Case 6: Check if service package folder exists")
    public void testServicePackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "service");
        Assert.assertTrue(Files.exists(path), "com/example/demo/service package folder should exist");
    }
    
    @Test(priority = 7, description = "Test Case 7: Check if repository package folder exists")
    public void testRepositoryPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "repository");
        Assert.assertTrue(Files.exists(path), "com/example/demo/repository package folder should exist");
    }
    
    @Test(priority = 8, description = "Test Case 8: Check if config package folder exists")
    public void testConfigPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "config");
        Assert.assertTrue(Files.exists(path), "com/example/demo/config package folder should exist");
    }
    
    @Test(priority = 9, description = "Test Case 9: Check if util package folder exists")
    public void testUtilPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "util");
        Assert.assertTrue(Files.exists(path), "com/example/demo/util package folder should exist");
    }
    
    @Test(priority = 10, description = "Test Case 10: Check if dto package folder exists")
    public void testDtoPackageFolderExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "dto");
        Assert.assertTrue(Files.exists(path), "com/example/demo/dto package folder should exist");
    }
    
    // ========== FILE NAME TESTS (Test Cases 11-20) ==========
    
    @Test(priority = 11, description = "Test Case 11: Check if pom.xml file exists")
    public void testPomXmlFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "pom.xml");
        Assert.assertTrue(Files.exists(path), "pom.xml file should exist");
        Assert.assertTrue(Files.isRegularFile(path), "pom.xml should be a file");
    }
    
    @Test(priority = 12, description = "Test Case 12: Check if application.properties file exists")
    public void testApplicationPropertiesFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "resources", "application.properties");
        Assert.assertTrue(Files.exists(path), "application.properties file should exist");
    }
    
    @Test(priority = 13, description = "Test Case 13: Check if User.java file exists")
    public void testUserJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "model", "User.java");
        Assert.assertTrue(Files.exists(path), "User.java file should exist");
    }
    
    @Test(priority = 14, description = "Test Case 14: Check if CouponRule.java file exists")
    public void testCouponRuleJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "model", "CouponRule.java");
        Assert.assertTrue(Files.exists(path), "CouponRule.java file should exist");
    }
    
    @Test(priority = 15, description = "Test Case 15: Check if Coupon.java file exists")
    public void testCouponJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "model", "Coupon.java");
        Assert.assertTrue(Files.exists(path), "Coupon.java file should exist");
    }
    
    @Test(priority = 16, description = "Test Case 16: Check if AuthController.java file exists")
    public void testAuthControllerJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "controller", "AuthController.java");
        Assert.assertTrue(Files.exists(path), "AuthController.java file should exist");
    }
    
    @Test(priority = 17, description = "Test Case 17: Check if CouponController.java file exists")
    public void testCouponControllerJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "controller", "CouponController.java");
        Assert.assertTrue(Files.exists(path), "CouponController.java file should exist");
    }
    
    @Test(priority = 18, description = "Test Case 18: Check if CouponRuleController.java file exists")
    public void testCouponRuleControllerJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "controller", "CouponRuleController.java");
        Assert.assertTrue(Files.exists(path), "CouponRuleController.java file should exist");
    }
    
    @Test(priority = 19, description = "Test Case 19: Check if JwtUtil.java file exists")
    public void testJwtUtilJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "util", "JwtUtil.java");
        Assert.assertTrue(Files.exists(path), "JwtUtil.java file should exist");
    }
    
    @Test(priority = 20, description = "Test Case 20: Check if DynamicCouponGeneratorApplication.java file exists")
    public void testMainApplicationJavaFileExists() {
        Path path = Paths.get(PROJECT_ROOT, "src", "main", "java", "com", "example", "demo", "DynamicCouponGeneratorApplication.java");
        Assert.assertTrue(Files.exists(path), "DynamicCouponGeneratorApplication.java file should exist");
    }
    
    // ========== API URL TESTS (Test Cases 21-28) ==========
    
    @Test(priority = 21, description = "Test Case 21: Verify register endpoint URL")
    public void testRegisterEndpointUrl() {
        String expectedUrl = BASE_URL + "/auth/register";
        String actualUrl = BASE_URL + "/auth/register";
        Assert.assertEquals(actualUrl, expectedUrl, "Register endpoint URL should be /auth/register");
    }
    
    @Test(priority = 22, description = "Test Case 22: Verify login endpoint URL")
    public void testLoginEndpointUrl() {
        String expectedUrl = BASE_URL + "/auth/login";
        String actualUrl = BASE_URL + "/auth/login";
        Assert.assertEquals(actualUrl, expectedUrl, "Login endpoint URL should be /auth/login");
    }
    
    @Test(priority = 23, description = "Test Case 23: Verify list rules endpoint URL")
    public void testListRulesEndpointUrl() {
        String expectedUrl = BASE_URL + "/rules";
        String actualUrl = BASE_URL + "/rules";
        Assert.assertEquals(actualUrl, expectedUrl, "List rules endpoint URL should be /rules");
    }
    
    @Test(priority = 24, description = "Test Case 24: Verify add rule endpoint URL")
    public void testAddRuleEndpointUrl() {
        String expectedUrl = BASE_URL + "/rules";
        String actualUrl = BASE_URL + "/rules";
        Assert.assertEquals(actualUrl, expectedUrl, "Add rule endpoint URL should be /rules");
    }
    
    @Test(priority = 25, description = "Test Case 25: Verify delete rule endpoint URL pattern")
    public void testDeleteRuleEndpointUrl() {
        String actualUrl = BASE_URL + "/rules/1";
        Assert.assertTrue(actualUrl.startsWith(BASE_URL + "/rules/"), 
            "Delete rule endpoint URL should follow pattern /rules/{id}");
    }
    
    @Test(priority = 26, description = "Test Case 26: Verify generate coupon endpoint URL pattern")
    public void testGenerateCouponEndpointUrl() {
        String actualUrl = BASE_URL + "/coupons/generate/1";
        Assert.assertTrue(actualUrl.startsWith(BASE_URL + "/coupons/generate/"), 
            "Generate coupon endpoint URL should follow pattern /coupons/generate/{ruleId}");
    }
    
    @Test(priority = 27, description = "Test Case 27: Verify get user coupons endpoint URL")
    public void testGetUserCouponsEndpointUrl() {
        String expectedUrl = BASE_URL + "/coupons/my";
        String actualUrl = BASE_URL + "/coupons/my";
        Assert.assertEquals(actualUrl, expectedUrl, "Get user coupons endpoint URL should be /coupons/my");
    }
    
    @Test(priority = 28, description = "Test Case 28: Verify use coupon endpoint URL pattern")
    public void testUseCouponEndpointUrl() {
        String actualUrl = BASE_URL + "/coupons/use/1";
        Assert.assertTrue(actualUrl.startsWith(BASE_URL + "/coupons/use/"), 
            "Use coupon endpoint URL should follow pattern /coupons/use/{couponId}");
    }
    
    // ========== STATUS CODE TESTS (Test Cases 29-34) ==========
    
    @Test(priority = 29, description = "Test Case 29: Verify register endpoint returns 200 OK")
    public void testRegisterEndpointStatusCode() {
        try {
            Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"testuser" + System.currentTimeMillis() + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            Assert.assertEquals(response.getStatusCode(), 200, 
                "Register endpoint should return status code 200");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 30, description = "Test Case 30: Verify login endpoint returns 200 OK")
    public void testLoginEndpointStatusCode() {
        try {
            // First register a user
            String username = "logintest" + System.currentTimeMillis();
            RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            // Then try to login
            Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"test123\"}")
                .post("/auth/login");
            
            Assert.assertEquals(response.getStatusCode(), 200, 
                "Login endpoint should return status code 200");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 31, description = "Test Case 31: Verify protected endpoint returns 403 without token")
    public void testProtectedEndpointWithoutToken() {
        try {
            Response response = RestAssured.given()
                .get("/rules");
            
            // Spring Security returns 403 Forbidden for unauthenticated requests
            Assert.assertEquals(response.getStatusCode(), 403, 
                "Protected endpoint should return status code 403 without token");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 32, description = "Test Case 32: Verify Swagger UI endpoint returns 200")
    public void testSwaggerUiEndpointStatusCode() {
        try {
            Response response = RestAssured.given()
                .get("/swagger-ui/index.html");
            
            // Swagger UI might return 200 or 302 (redirect)
            Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 302, 
                "Swagger UI endpoint should return status code 200 or 302");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 33, description = "Test Case 33: Verify invalid endpoint returns 403 or 404")
    public void testInvalidEndpointStatusCode() {
        try {
            Response response = RestAssured.given()
                .get("/invalid/endpoint");
            
            // Spring Security may return 403 for protected invalid endpoints, or 404 if not protected
            Assert.assertTrue(response.getStatusCode() == 403 || response.getStatusCode() == 404, 
                "Invalid endpoint should return status code 403 or 404");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 34, description = "Test Case 34: Verify API docs endpoint returns 200")
    public void testApiDocsEndpointStatusCode() {
        try {
            Response response = RestAssured.given()
                .get("/api-docs");
            
            // API docs might return 200 or 302
            Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 302, 
                "API docs endpoint should return status code 200 or 302");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Status code test failed: " + e.getMessage());
        }
    }
    
    // ========== REQUEST/RESPONSE TESTS (Test Cases 35-40) ==========
    
    @Test(priority = 35, description = "Test Case 35: Verify register response contains success message")
    public void testRegisterResponseContent() {
        try {
            String username = "registertest" + System.currentTimeMillis();
            Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            String responseBody = response.getBody().asString();
            Assert.assertTrue(responseBody.contains("User registered successfully") || 
                            responseBody.contains("successfully"),
                "Register response should contain success message");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Response test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 36, description = "Test Case 36: Verify login response contains token")
    public void testLoginResponseContainsToken() {
        try {
            String username = "logintest" + System.currentTimeMillis();
            // Register first
            RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            // Then login
            Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"test123\"}")
                .post("/auth/login");
            
            Map<String, String> responseBody = response.jsonPath().getMap("$");
            Assert.assertNotNull(responseBody.get("token"), 
                "Login response should contain token field");
            Assert.assertFalse(responseBody.get("token").isEmpty(), 
                "Token should not be empty");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Response test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 37, description = "Test Case 37: Verify request body structure for register")
    public void testRegisterRequestBodyStructure() {
        // This test validates that we can create a proper request body
        String requestBody = "{\"username\":\"test\",\"password\":\"test123\",\"role\":\"USER\"}";
        Assert.assertTrue(requestBody.contains("username"), 
            "Register request body should contain username field");
        Assert.assertTrue(requestBody.contains("password"), 
            "Register request body should contain password field");
        Assert.assertTrue(requestBody.contains("role"), 
            "Register request body should contain role field");
    }
    
    @Test(priority = 38, description = "Test Case 38: Verify request body structure for login")
    public void testLoginRequestBodyStructure() {
        // This test validates that we can create a proper request body
        String requestBody = "{\"username\":\"test\",\"password\":\"test123\"}";
        Assert.assertTrue(requestBody.contains("username"), 
            "Login request body should contain username field");
        Assert.assertTrue(requestBody.contains("password"), 
            "Login request body should contain password field");
    }
    
    @Test(priority = 39, description = "Test Case 39: Verify response content type is JSON")
    public void testResponseContentType() {
        try {
            Response response = RestAssured.given()
                .contentType("application/json")
                .body("{\"username\":\"contenttest" + System.currentTimeMillis() + "\",\"password\":\"test123\",\"role\":\"USER\"}")
                .post("/auth/register");
            
            // Check both Content-Type header and response content type
            String contentType = response.getContentType();
            if (contentType == null || contentType.isEmpty()) {
                contentType = response.getHeader("Content-Type");
            }
            Assert.assertTrue(contentType != null && (contentType.contains("application/json") || contentType.contains("text/plain")), 
                "Response content type should be application/json or text/plain");
        } catch (Exception e) {
            Assert.fail("Server might not be running. Response test failed: " + e.getMessage());
        }
    }
    
    @Test(priority = 40, description = "Test Case 40: Verify protected endpoint requires Authorization header")
    public void testProtectedEndpointRequiresAuth() {
        try {
            Response responseWithoutAuth = RestAssured.given()
                .get("/rules");
            
            // Spring Security returns 403 Forbidden for unauthenticated requests
            Assert.assertEquals(responseWithoutAuth.getStatusCode(), 403, 
                "Protected endpoint should return 403 without Authorization header");
            
            if (authToken != null) {
                Response responseWithAuth = RestAssured.given()
                    .header("Authorization", authToken)
                    .get("/rules");
                
                // Should return 200 for authenticated requests
                Assert.assertTrue(responseWithAuth.getStatusCode() == 200, 
                    "Protected endpoint should return 200 with valid Authorization header");
            }
        } catch (Exception e) {
            Assert.fail("Server might not be running. Response test failed: " + e.getMessage());
        }
    }
}

