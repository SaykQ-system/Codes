def dijkstra(graph,src,dest,visited=[],distances={},predecessors={}):
    #başlangıç noktası bitiş noktasına eşit ise if koşulunu çalıştır istiyoruz.    
    if src == dest:
        path=[]
        pred=dest
        while pred != None:
            path.append(pred)
            pred=predecessors.get(pred,None)
        # çıkan sonuçta yolu düzgün görünteleye bilmek için düz ceviriliyor.
        readable=path[0]
        for index in range(1,len(path)): readable = path[index]+' --> '+readable
        #çıkan sonucu yani yol ve maliyeti ekrana yazdırılıyor.
        print("En Kısa Yol: "+readable+", Maliyet = "+str(distances[dest]))
    #başlangıç noktası bitiş noktasına eşit değil ise else koşulu ile hesaplamaya devam et istiyoruz.    
    else :
        if not visited: 
            distances[src]=0
        #komşuları ziyaret etmesini istiyoruz.
        for neighbor in graph[src] :
            if neighbor not in visited:
                new_distance = distances[src] + graph[src][neighbor]
                if new_distance < distances.get(neighbor,float('inf')):
                    distances[neighbor] = new_distance
                    predecessors[neighbor] = src
                    #geçti yolun ağırlığının ve bir önçeki en kısa yol ile o anki toplamını (maliyetini) yazdırılıyor.
                    print(src, ">",neighbor, "=","Arası Toplam Maliyet: ",new_distance)
        #ziyaret edilen komşulukları listelemesini istiyoruz.            
        visited.append(src)                        
        unvisited={}
        #tüm komşulukları ziyaret etmediyse tekrar etmesini istiyoruz.
        for k in graph:
            if k not in visited:
                unvisited[k] = distances.get(k,float('inf'))
        # ve en düşük x mesafesine sahip ziyaret edilmiş düğümü al diyoruz.                
        x=min(unvisited, key=unvisited.get)
        #Dijskstra yı çalıştırıyoruz
        dijkstra(graph,x,dest,visited,distances,predecessors)
        
if __name__ == "__main__":
    #graphımızın düğüm ve nokta ve ağırlıklarını yazıyoruz. Sözlük ile listeliyoruz.
    graph = {
            '1': {'2': 2, '3': 3, '4': 4},
            '2': {'1': 2, '5': 2, '6': 3},
            '3': {'1': 3, '7': 1},
            '4': {'1': 4, '7': 4, '8': 2},
            '5': {'2': 2, '6': 7},
            '6': {'2': 3, '5': 7, '8': 4},
            '7': {'8': 3, '4': 4, '3': 1},
            '8': {'4': 2, '6': 4, '7': 3},
            }
    #başlangıç ve bitiş noktası belirliyoruz.        
    dijkstra(graph,'1','8')