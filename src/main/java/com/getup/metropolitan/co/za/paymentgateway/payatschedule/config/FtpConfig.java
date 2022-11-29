//package com.getup.metropolitan.co.za.paymentgateway.payatschedule.config;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import za.co.metropolitan.integration.ftp.FtpService;
//import za.co.metropolitan.integration.ftp.SFTPService;
//
//import javax.annotation.Resource;
//
//
//@Configuration
//    public class FtpConfig {
//
//    @Value("${sftp.host}")
//    private String FTP_HOST;
//    @Value("${sftp.key}")
//    private Resource FTP_PRV_KEY;
//    @Value("${sftp.user}")
//    private String FTP_USER;
//
//    @Bean
//    public FtpService ftpService() {
//        return new SFTPService(this.FTP_HOST, this.FTP_PRV_KEY, this.FTP_USER);
//    }
//
////
////    @Bean
////  //  @InboundChannelAdapter(value = "fileInputChannel")
////    public FileReadingMessageSource fileReadingMessageSource() {
////        CompositeFileListFilter<File> filter = new CompositeFileListFilter<File>();
////        filter.addFilter(new SimplePatternFileListFilter(".csv"));
////        FileReadingMessageSource readder = new FileReadingMessageSource();
////        String path = "C:\\Users\\arnkosi\\Desktop\\sftpstuff";
////        readder.setDirectory(new File(path));
////        readder.setFilter(filter);
////        return readder;
////    }
//}
