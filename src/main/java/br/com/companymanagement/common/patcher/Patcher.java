package br.com.companymanagement.common.patcher;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import br.com.companymanagement.common.exception.BadRequestException;

public class Patcher {
	
	public static <T> T applyPatch(String jsonPatch, T resource, Class<T> clazz) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			JsonPatch patch = mapper.readValue(jsonPatch, JsonPatch.class);
			JsonNode node = mapper.valueToTree(resource);

			JsonNode patched = patch.apply(node);

			resource = mapper.treeToValue(patched, clazz);
			return resource;

		} catch (JsonPatchException ex) {
			throw new BadRequestException("Erro aplicando json patch a entidade <" + clazz + ">. Json Patch: " + jsonPatch + ". Erro: " + ex.getMessage(), ex);
		} catch (IOException ex) {
			throw new BadRequestException("Erro aplicando json patch a entidade <" + clazz + ">. Json Patch: " + jsonPatch + ". Erro: " + ex.getMessage(), ex);
		}
	}
	
}
