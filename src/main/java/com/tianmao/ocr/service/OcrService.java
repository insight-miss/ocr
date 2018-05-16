package com.tianmao.ocr.service;

import com.tianmao.ocr.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OcrService {

    public void Tem(int w,int h,String path,String newpath){
        try {
            BufferedImage image = ImageIO.read(new FileInputStream(path));
            BufferedImage nbi=new BufferedImage(w,h-8,image.getType());

            for (int x = 0; x < w; x++) {
                for (int y = 8; y < h; y++) {
                    if(image.getRGB(x, y)==0)
                    {
                        image.setRGB(x, y, -1);
                    }
                    nbi.setRGB(x, y-8,image.getRGB(x, y));
                }
            }
            ImageIO.write(nbi, "png", new File(newpath));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ResultDTO> FilePath(String path){

        List<ResultDTO> resultDTOList = new ArrayList<>();

        ITesseract instance = new Tesseract();
        instance.setDatapath("/home/twl/IdeaProjects/ocr/src/main/resources/tessdata/");
        instance.setLanguage("new+chi_sim");//添加中文字库
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f:files)
        {
            if(f.isFile())
            {
                Tem(520,75,f.getPath(),f.getParent()+"/p/"+f.getName());
                File imageFile = new File(f.getParent()+"/p/"+f.getName());
                try {
                    String result = instance.doOCR(imageFile);
                    System.out.println(result);
                    String[] ans = result.split("\n");
                    String name=null;
                    String number=null;
                    if (ans.length>=2) {
                        String[] temp1 = ans[0].split(":");
                        String[] temp2 = ans[1].split(":");
                        if (temp1.length>=2) {
                            number = temp1[1];
                        }
                        if (temp2.length>=2) {
                            name = temp2[1];
                        }
                    }

                    ResultDTO resultDTO = new ResultDTO();
                    resultDTO.setNumber(number);
                    resultDTO.setName(name);

                    resultDTOList.add(resultDTO);

                    log.info("length={}",ans.length);
                    log.info("企业注册号为：{} 企业名称为：{}",number,name);

                } catch (TesseractException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return resultDTOList;
    }
}
