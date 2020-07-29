// 장르는 2개까지만 저장.
// 장르 - 재생횟수 많은 것.
// 장르 내 - 노래 - 재생횟수 많은 것.
// 장르 내 - 노래 - 재생횟수 - 같은 것 중 - 번호가 낮은 노래 먼저.
// 고유 번호 : 배열 번호.

import java.util.*;

class Solution {
    public static class Song{
        int sum;
        int[] num;
        
        public Song(int play, int p){
            num = new int[2];
            num[0] = p;
            num[1] = -1;
            sum = play;
        }
        
        public void setSong(int p, int[] plays){
            sum += plays[p];
            
            if(plays[num[0]] < plays[p]){
                num[1] = num[0];
                num[0] = p;
            }
            else if(num[1] == -1 || plays[num[1]] < plays[p])
                num[1] = p;
        }
        
        public int[] getNum(){
            return num;
        }
        
        public int getSum(){
            return sum;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Song> map = new HashMap<String, Song>();
        
        for(int i = 0; i < genres.length; i++){
            if(!map.containsKey(genres[i])){            // 맵에 장르가 없으면 객체 생성하고 객체를 맵에 넣음.
                Song song = new Song(plays[i], i);
                map.put(genres[i], song);
            }
            else{
                Song song = map.get(genres[i]);         // 있으면 객체 가져옴.
                song.setSong(i, plays);                 // 재생횟수 설정하기 위해 배열과 인수 넘김.
                map.put(genres[i], song);               // 썼으니 다시 넣음.
            }
        }
        
        Iterator<String> iterator = map.keySet().iterator();
        List<Song> list = new LinkedList<>();
        
        int size = 0;
        
        while(iterator.hasNext()){
            String key = iterator.next();
            Song song = map.get(key);
            
            if(song.getNum()[1] == -1)
                size++;
            else
                size += 2;
            
            list.add(map.get(key));
        }
        
        Collections.sort(list, new Comparator<Song>(){
            @Override
            public int compare(Song s1, Song s2){
                return s2.getSum() - s1.getSum();
            }
        });
        
        int[] answer = new int[size];
        int i = 0;
        
        for(Song song : list){
            answer[i++] = song.getNum()[0];
            
            if(song.getNum()[1] != -1)
                answer[i++] = song.getNum()[1];
        }
        
        return answer;
    }
}