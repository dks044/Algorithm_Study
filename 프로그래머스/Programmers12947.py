def solution(x):
    x = str(x)
    sum = 0
    for i in range(len(x)):
        sum += int(x[i])
    
    x = int(x)
    
    return x % sum == 0
