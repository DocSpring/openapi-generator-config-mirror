package com.docspring;

import com.docspring.ApiClient;
import com.docspring.AddFieldsData;
import com.docspring.AddFieldsTemplateResponse;
import com.docspring.AuthenticationError;
import com.docspring.AuthenticationSuccessResponse;
import com.docspring.CombinePdfsData;
import com.docspring.CombinedSubmission;
import com.docspring.CombinedSubmissionData;
import com.docspring.CreateCombinedSubmissionResponse;
import com.docspring.CreateCustomFileData;
import com.docspring.CreateCustomFileResponse;
import com.docspring.CreateFolderData;
import com.docspring.CreateHtmlTemplateData;
import com.docspring.CreateSubmissionBatchResponse;
import com.docspring.CreateSubmissionDataRequestTokenResponse;
import com.docspring.CreateSubmissionResponse;
import com.docspring.CreateTemplateFromUploadData;
import com.docspring.Error;
import java.io.File;
import com.docspring.Folder;
import com.docspring.InvalidRequest;
import com.docspring.MoveFolderData;
import com.docspring.MoveTemplateData;
import com.docspring.PendingTemplate;
import com.docspring.RenameFolderData;
import com.docspring.Submission;
import com.docspring.SubmissionBatch;
import com.docspring.SubmissionBatchData;
import com.docspring.SubmissionData;
import com.docspring.SubmissionDataRequest;
import com.docspring.Template;
import com.docspring.UpdateDataRequestResponse;
import com.docspring.UpdateSubmissionDataRequestData;
import com.docspring.UpdateTemplateData;
import com.docspring.UpdateTemplateResponse;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * API tests for PdfApi
 */
public class PdfApiIntegrationTest {
  private PdfApi api;
  private static final Logger logger = LoggerFactory.getLogger(PdfApiIntegrationTest.class);

  @Before
  public void setup() {
    <%= render :setup_client %>
  }

    /**
     * Add new fields to a Template
     *
     *
     */
    @Test
    public void addFieldsToTemplateTest() {
        String templateId = null;
        AddFieldsData addFieldsData = null;
        // AddFieldsTemplateResponse response = api.addFieldsToTemplate(templateId, addFieldsData);

        // TODO: test validations
    }
    /**
     * Generates multiple PDFs
     *
     *
     */
    @Test
    public void batchGeneratePdfV1Test() {
        String templateId = null;
        List<Object> requestBody = null;
        // List<CreateSubmissionResponse> response = api.batchGeneratePdfV1(templateId, requestBody);

        // TODO: test validations
    }
    /**
     * Generates multiple PDFs
     *
     *
     */
    @Test
    public void batchGeneratePdfsTest() {
        SubmissionBatchData submissionBatchData = null;
        // CreateSubmissionBatchResponse response = api.batchGeneratePdfs(submissionBatchData);

        // TODO: test validations
    }
    /**
     * Merge submission PDFs, template PDFs, or custom files
     *
     *
     */
    @Test
    public void combinePdfsTest() {
        CombinePdfsData combinePdfsData = null;
        // CreateCombinedSubmissionResponse response = api.combinePdfs(combinePdfsData);

        // TODO: test validations
    }
    /**
     * Merge generated PDFs together
     *
     *
     */
    @Test
    public void combineSubmissionsTest() {
        CombinedSubmissionData combinedSubmissionData = null;
        // CreateCombinedSubmissionResponse response = api.combineSubmissions(combinedSubmissionData);

        // TODO: test validations
    }
    /**
     * Create a new custom file from a cached presign upload
     *
     *
     */
    @Test
    public void createCustomFileFromUploadTest() {
        CreateCustomFileData createCustomFileData = null;
        // CreateCustomFileResponse response = api.createCustomFileFromUpload(createCustomFileData);

        // TODO: test validations
    }
    /**
     * Creates a new data request token for form authentication
     *
     *
     */
    @Test
    public void createDataRequestTokenTest() {
        String dataRequestId = null;
        // CreateSubmissionDataRequestTokenResponse response = api.createDataRequestToken(dataRequestId);

        // TODO: test validations
    }
    /**
     * Create a folder
     *
     *
     */
    @Test
    public void createFolderTest() {
        CreateFolderData createFolderData = null;
        // Folder response = api.createFolder(createFolderData);

        // TODO: test validations
    }
    /**
     * Create a new HTML template
     *
     *
     */
    @Test
    public void createHTMLTemplateTest() {
        CreateHtmlTemplateData createHtmlTemplateData = null;
        // PendingTemplate response = api.createHTMLTemplate(createHtmlTemplateData);

        // TODO: test validations
    }
    /**
     * Create a new PDF template with a form POST file upload
     *
     *
     */
    @Test
    public void createPDFTemplateTest() throws java.io.IOException {
        <%= test_for :create_pdf_template, type: :original %>
    }
    /**
     * Create a new PDF template from a cached presign upload
     *
     *
     */

    // @Test
    // public void createPDFTemplateFromUploadTest() {
    //     <%#= test_for :create_pdf_template_from_upload, type: :original %>
    // }

    /**
     * Delete a folder
     *
     *
     */
    @Test
    public void deleteFolderTest() {
        String folderId = null;
        // Folder response = api.deleteFolder(folderId);

        // TODO: test validations
    }
    /**
     * Expire a combined submission
     *
     *
     */
    @Test
    public void expireCombinedSubmissionTest() {
        String combinedSubmissionId = null;
        // CombinedSubmission response = api.expireCombinedSubmission(combinedSubmissionId);

        // TODO: test validations
    }
    /**
     * Expire a PDF submission
     *
     *
     */
    @Test
    public void expireSubmissionTest() {
        String submissionId = null;
        // Submission response = api.expireSubmission(submissionId);

        // TODO: test validations
    }

    /**
     * Generates a new PDF
     *
     *
     */
    @Test
    public void generatePDFTest() throws java.io.IOException {
      <%= test_for :generate_pdf, type: :original %>
    }

  /**
   * Generates a new PDF with a Data Request
   *
   *
   */
  @Test
  public void generatePDFWithDataRequestTest() throws java.io.IOException {
    String templateId = "tpl_000000000000000001";
    SubmissionData submissionData = new SubmissionData();
    Map<String, String> data = new HashMap<>();
    data.put("title", "Test PDF");
    data.put("description", "This PDF is great!");
    submissionData.setData(data);

    List<CreateSubmissionDataRequestData> dataRequestsList = new ArrayList<>();
    CreateSubmissionDataRequestData dataRequestData = new CreateSubmissionDataRequestData();
    dataRequestData.setAuthType(CreateSubmissionDataRequestData.AuthTypeEnum.EMAIL_LINK);
    dataRequestData.setName("John Smith");
    dataRequestData.setEmail("jsmith@example.com");
    List<String> fields = new ArrayList<>();
    fields.add("description");
    dataRequestData.setFields(fields);

    dataRequestsList.add(dataRequestData);
    submissionData.setDataRequests(dataRequestsList);

    retrofit2.Response<CreateSubmissionResponse> retrofitResponse = api.generatePDF(templateId, submissionData)
        .execute();
    if (!retrofitResponse.isSuccessful()) {
      logger.info(retrofitResponse.errorBody().string());
    }
    assertEquals(201, retrofitResponse.code());
    CreateSubmissionResponse response = retrofitResponse.body();

    assertEquals(CreateSubmissionResponse.StatusEnum.SUCCESS, response.getStatus());

    Submission submission = response.getSubmission();
    assertThat(submission.getId(), startsWith("sub_"));
    assertEquals(false, submission.getExpired());
    assertEquals(Submission.StateEnum.WAITING_FOR_DATA_REQUESTS, submission.getState());

    assertEquals(1, submission.getDataRequests().size());
    SubmissionDataRequest dataRequest = submission.getDataRequests().get(0);
    assertThat(dataRequest.getId(), startsWith("drq_"));
    assertEquals(SubmissionDataRequest.StateEnum.PENDING, dataRequest.getState());
    assertThat(dataRequest.getFields(), is(Arrays.asList("description")));
    assertEquals(new Integer(0), new Integer(dataRequest.getOrder()));
    assertEquals("John Smith", dataRequest.getName());
    assertEquals("jsmith@example.com", dataRequest.getEmail());
  }


    /**
     * Check the status of a combined submission (merged PDFs)
     *
     *
     */
    @Test
    public void getCombinedSubmissionTest() {
        String combinedSubmissionId = null;
        // CombinedSubmission response = api.getCombinedSubmission(combinedSubmissionId);

        // TODO: test validations
    }
    /**
     * Look up a submission data request
     *
     *
     */
    @Test
    public void getDataRequestTest() {
        String dataRequestId = null;
        // SubmissionDataRequest response = api.getDataRequest(dataRequestId);

        // TODO: test validations
    }
    /**
     * Get a presigned URL so that you can upload a file to our AWS S3 bucket
     *
     *
     */
    @Test
    public void getPresignUrlTest() {
        // Map<String, Object> response = api.getPresignUrl();

        // TODO: test validations
    }
    /**
     * Check the status of a PDF
     *
     *
     */
    @Test
    public void getSubmissionTest() {
        String submissionId = null;
        Boolean includeData = null;
        // Submission response = api.getSubmission(submissionId, includeData);

        // TODO: test validations
    }
    /**
     * Check the status of a submission batch job
     *
     *
     */
    @Test
    public void getSubmissionBatchTest() {
        String submissionBatchId = null;
        Boolean includeSubmissions = null;
        // SubmissionBatch response = api.getSubmissionBatch(submissionBatchId, includeSubmissions);

        // TODO: test validations
    }
    /**
     * Get a single template
     *
     *
     */
    @Test
    public void getTemplateTest() {
        String templateId = null;
        // Template response = api.getTemplate(templateId);

        // TODO: test validations
    }
    /**
     * Fetch the JSON schema for a template
     *
     *
     */
    @Test
    public void getTemplateSchemaTest() {
        String templateId = null;
        // Map<String, Object> response = api.getTemplateSchema(templateId);

        // TODO: test validations
    }
    /**
     * Get a list of all folders
     *
     *
     */
    @Test
    public void listFoldersTest() {
        String parentFolderId = null;
        // List<Folder> response = api.listFolders(parentFolderId);

        // TODO: test validations
    }
    /**
     * Get a list of all templates
     *
     *
     */
    @Test
    public void listTemplatesTest() throws java.io.IOException {
      String query = "API Client Test Template 2";
      Integer page = 1;
      Integer perPage = 10;

      retrofit2.Response<List<Template>> retrofitResponse = api.listTemplates(query, null, page, perPage).execute();
      if (!retrofitResponse.isSuccessful()) {
        logger.info(retrofitResponse.errorBody().string());
      }
      assertEquals(200, retrofitResponse.code());
      List<Template> response = retrofitResponse.body();

      assertEquals(1, response.size());
      assertEquals("tpl_000000000000000002", response.get(0).getId());
    }
    /**
     * Move a folder
     *
     *
     */
    @Test
    public void moveFolderToFolderTest() {
        String folderId = null;
        MoveFolderData moveFolderData = null;
        // Folder response = api.moveFolderToFolder(folderId, moveFolderData);

        // TODO: test validations
    }
    /**
     * Move Template to folder
     *
     *
     */
    @Test
    public void moveTemplateToFolderTest() {
        String templateId = null;
        MoveTemplateData moveTemplateData = null;
        // Template response = api.moveTemplateToFolder(templateId, moveTemplateData);

        // TODO: test validations
    }
    /**
     * Rename a folder
     *
     *
     */
    @Test
    public void renameFolderTest() {
        String folderId = null;
        RenameFolderData renameFolderData = null;
        // api.renameFolder(folderId, renameFolderData);

        // TODO: test validations
    }
    /**
     * Test Authentication
     *
     *
     */
    @Test
    public void testAuthenticationTest() throws java.io.IOException {
      retrofit2.Response<AuthenticationSuccessResponse> response = api.testAuthentication().execute();

      assertEquals(AuthenticationSuccessResponse.StatusEnum.SUCCESS, response.body().getStatus());
    }

    /**
     * Update a submission data request
     *
     *
     */
    @Test
    public void updateDataRequestTest() {
        String dataRequestId = null;
        UpdateSubmissionDataRequestData updateSubmissionDataRequestData = null;
        // UpdateDataRequestResponse response = api.updateDataRequest(dataRequestId, updateSubmissionDataRequestData);

        // TODO: test validations
    }

    /**
     * Update a Template
     *
     *
     */
    @Test
    public void updateTemplateTest() {
        String templateId = null;
        UpdateTemplateData updateTemplateData = null;
        // UpdateTemplateResponse response = api.updateTemplate(templateId, updateTemplateData);

        // TODO: test validations
    }
}
