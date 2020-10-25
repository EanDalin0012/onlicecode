package com.onlinecode.admins.utils;
import com.onlinecode.utils.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Base64ImageUtil {
    private static final Logger log = LoggerFactory.getLogger(Base64ImageUtil.class);

    public static String decodeToImage(String path, String base64, String fileName, String fileExtension) {
        log.info("===========Start write base64 ========");
        String fullPath = "";
        try {
            /*
             * Check file directory
             * */
            String mkdir = SystemUtil.projectPath() + path;
            File f = new File(mkdir);
            if (!f.exists()) {
                log.info("path exits");
                f.mkdirs();
            }
            fullPath = path+"/"+fileName+"."+fileExtension;
            log.info("full path:"+fullPath);
            byte[] base64Val=convertToImg(base64);
            writeByteToImageFile(base64Val, mkdir+"/"+fileName+"."+fileExtension);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("write base64 error", e);
        }

        log.info("===========End write base64 ========");
        return fullPath;
    }

    private static byte[] convertToImg(String base64) throws IOException{
        return org.apache.commons.codec.binary.Base64.decodeBase64(base64);
    }
    private static void writeByteToImageFile(byte[] imgBytes, String imgFileName) throws IOException {
        File imgFile = new File(imgFileName);
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgBytes));
        ImageIO.write(img, "png", imgFile);
    }
/*byte[] imageBytes = IOUtils.toByteArray(new URL("...")));
String base64 = Base64.getEncoder().encodeToString(imageBytes);*/

}
