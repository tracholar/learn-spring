package com.tracholar.web.demo;

import org.jets3t.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

/**
 * Created by zuoyuan on 2018/12/27.
 */
@Controller
@RequestMapping("/file")
public class FileUploader {
    Logger logger = LoggerFactory.getLogger(this.getClass());


    @GetMapping("/upload")
    public String showUploadPage() {
        return ("upload_file");
    }
    @PostMapping("/upload")
    public String uploadHandler(@RequestParam("file") MultipartFile file,
                                RedirectAttributes redirectAttributes) throws IOException{
        logger.info(file.getOriginalFilename());
        File f = new File("/tmp/www_upload/" + file.getOriginalFilename());
        logger.info("Move to " + f.getAbsolutePath());
        file.transferTo(f);
        redirectAttributes.addFlashAttribute("message", "You successfully upload " + file.getOriginalFilename());
        return "redirect:/";
    }
}
