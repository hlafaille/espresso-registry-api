package com.kerosenelabs.espressoregistryapi.handler;

import com.kerosenelabs.kindling.exception.KindlingException;
import com.squareup.moshi.Types;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import com.squareup.moshi.Moshi;
import com.kerosenelabs.espressoregistryapi.model.Group;
import com.kerosenelabs.espressoregistryapi.service.RegistryService;
import com.kerosenelabs.kindling.HttpRequest;
import com.kerosenelabs.kindling.HttpResponse;
import com.kerosenelabs.kindling.constant.HttpStatus;
import com.kerosenelabs.kindling.constant.MimeType;
import com.squareup.moshi.JsonAdapter;

public class QueryHandler extends BaseHandler {
    // dependencies
    private RegistryService registryService = RegistryService.getInstance();

    @Override
    public HttpResponse handle(HttpRequest httpRequest) throws KindlingException {
        if (httpRequest.getQueryParmeters().isEmpty()) {
            throw new KindlingException("This endpoint requires the query parameter 'q'");
        }

        // do our query
        String queryValue = httpRequest.getQueryParmeters().get("q");
        List<Group> groups = registryService.queryGroupsForPackages(Optional.of(queryValue));

        // build moshi for json
        var moshi = new Moshi.Builder().build();
        ParameterizedType listType = Types.newParameterizedType(List.class, Group.class);
        JsonAdapter<List<Group>> jsonAdapter = moshi.adapter(listType);
        return new HttpResponse.Builder()
                .status(HttpStatus.OK)
                .contentType(MimeType.APPLICATION_JSON)
                .content(jsonAdapter.toJson(groups))
                .build();
    }

    @Override
    public boolean accepts(HttpRequest httpRequest) throws KindlingException {
        return httpRequest.getPath().equals("/registry");
    }
}
