package com.scott.b_springData2_self_project2022a.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.scott.b_springData2_self_project2022a.models.Swimmer;
import com.scott.b_springData2_self_project2022a.models.TagCategory;
import com.scott.b_springData2_self_project2022a.models.User;
import com.scott.b_springData2_self_project2022a.repositories.TagCategoryRepository;

@Service
public class TagCategoryService {
	private final TagCategoryRepository tagCategoryRepository;
	public TagCategoryService(TagCategoryRepository tagCategoryRepository) {
		this.tagCategoryRepository=tagCategoryRepository;
	}
	public List<TagCategory> allTags(){
		return tagCategoryRepository.findAll();
	}
	public TagCategory findTag(Long id) {
		Optional<TagCategory> optional=tagCategoryRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public TagCategory createTag(TagCategory t) {
		return tagCategoryRepository.save(t);
	}
	public TagCategory updateTag(Long id, String tagTitle, List<Swimmer> swimmers, User host) {
		TagCategory t=findTag(id);
		t.setId(id);
		t.setTagName(tagTitle);
		t.setSwimmers(swimmers);
		t.setHost(host);
		return tagCategoryRepository.save(t);
	}
	public TagCategory updateTag(TagCategory t) {
		return tagCategoryRepository.save(t);
	}
	public void deleteTag(Long id) {
		tagCategoryRepository.deleteById(id);
	}
}
