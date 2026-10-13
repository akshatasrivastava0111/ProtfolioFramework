package com.stark.automation.api.models.response;
import java.util.List;
public record PostResponse(int id, String title, String body, int userId, List<String> tags, boolean isDeleted, String deletedOn) { }
