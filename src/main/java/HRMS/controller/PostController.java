package HRMS.controller;

import HRMS.repository.PostViewRepository;
import HRMS.view.PostView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostViewRepository postViewRepository;

    @GetMapping("/admin/list")
    public List<PostView> getList(){
        return postViewRepository.findAll();
    }
}
