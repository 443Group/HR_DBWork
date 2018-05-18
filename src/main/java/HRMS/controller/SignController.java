package HRMS.controller;

import HRMS.entity.Attendence;
import HRMS.entity.Login;
import HRMS.repository.AttendenceRepository;
import HRMS.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/sign")
public class SignController {
    @Autowired
    AttendenceRepository attendenceRepository;

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    private HttpServletRequest request;



    @GetMapping(value = "/sign")
    public Boolean Sign(Principal principal){
        Attendence attendence = new Attendence();
        attendence.setDate(LocalDateTime.now());
        attendence.setEmpId(Long.valueOf(principal.getName()));
        attendence.setIp(getIP(request));
        attendence.setType(54);
        attendence.setValue(0L);
        attendenceRepository.save(attendence);
        return Boolean.TRUE;
    }

/*    @GetMapping(value = "/IsSigned")
    public Boolean IsSigned(){
        if (attendenceRepository.find)
    };*/

    @GetMapping("/record")
    public List<Attendence> getRecord(Principal principal){
        return attendenceRepository.findByEmpId(Long.valueOf(principal.getName()));
    }



    public String getIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }


}
