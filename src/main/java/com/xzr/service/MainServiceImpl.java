package com.xzr.service;

import com.aliyuncs.exceptions.ClientException;
import com.xzr.dao.MainDAO;
import com.xzr.entity.Album;
import com.xzr.entity.Article;
import com.xzr.entity.Picture;
import com.xzr.entity.User;
import com.xzr.util.SendMessage;
import com.xzr.util.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by F on 2017/11/02.
 */
@Service("/mainService")
@Transactional
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDAO mainDAO;

    public List<Picture> queryAllPicture() {
        return mainDAO.queryAllPicture();
    }

    public List<Album> queryAllAlbum() {
        return mainDAO.queryAllAlbum();
    }

    public List<Article> queryAllArticle() {
        return mainDAO.queryAllArticle();
    }

    public User queryByPhone(String phone) {
        return mainDAO.queryByPhone(phone);
    }

    public void sendMessage(String phoneNum) throws ClientException {
        String code = ValidateImageCodeUtils.getSecurityCode(4, ValidateImageCodeUtils.SecurityCodeLevel.Hard, false);
        SendMessage sendMessage = new SendMessage();
        String send = sendMessage.send(phoneNum,code);
        Jedis jedis = new Jedis("192.168.127.128", 6379);
        if(send.equals("OK")){
            jedis.set(phoneNum,code);
            jedis.expire(phoneNum,300);
        }else{
            System.out.println("发送失败");
        }
    }

    public Map<String,String> save(String phoneNum, String code){
        Jedis jedis = new Jedis("192.168.127.128", 6379);
        HashMap<String,String> map = new HashMap<String, String>();
        String s = jedis.get(phoneNum);
        if(s==null){
            map.put("result","fail");
        }else if (code.equals(s)){
            map.put("result","success");
        }
        return map;
    }
}
