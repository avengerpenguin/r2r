/*
 *  R2R
 *
 *  Copyright 2010-2011 Freie Universität Berlin
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.avengerpenguin.r2r;

import java.util.Map;
import java.util.HashMap;

public class SimpleMappingCache {
	private MappingRepository repository;
	private Map<String, Mapping> cache;
	
	public SimpleMappingCache(MappingRepository repository) {
		this.repository = repository;
		cache = new HashMap<String, Mapping>();
	}
	
	public Mapping getMapping(String mappingURI) {
		if(cache.containsKey(mappingURI))
			return cache.get(mappingURI);
		
		Mapping mapping = repository.getMappingOfUri(mappingURI);
		cache.put(mappingURI, mapping);
		return mapping;
	}
}
