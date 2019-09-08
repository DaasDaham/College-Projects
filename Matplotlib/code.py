import math
from matplotlib.patches import Ellipse
import matplotlib.pyplot as plt
def l_scale(x,y,sx,sy):
    a=[[x],[y],[1]]
    b=[[sx,0,0],[0,sy,0],[0,0,1]]
    res=[]
    for i in range(len(b)):
        sum = 0
        for k in range(len(a)):
            sum += (b[i][k]*a[k][0])
        res += [[sum]]
    return res

def l_rotate(x,y,theta):
    if theta == 90 or theta == 180 or theta == 270 or theta == 360:
        rad = math.radians(theta)
        cos = round(math.cos(rad))
        sin = round(math.sin(rad))
    else:
        rad = math.radians(theta)
        cos = math.cos(rad)
        sin = math.sin(rad)
    a = [[x],[y],[1]]
    rot = [[cos,-sin,0],[sin,cos,0],[0,0,1]]
    res = []
    for i in range(len(rot)):
        sum = 0
        for k in range(len(a)):
            sum += (rot[i][k]*a[k][0])
        res+=[[sum]]
    return res

def l_translate(x,y,xt,yt):
    a = [[x],[y],[1]]
    b = [[1,0,xt],[0,1,yt],[0,0,1]]
    res=[]
    for i in range(len(b)):
        sum = 0
        for k in range(len(a)):
            sum += (b[i][k]*a[k][0])
        res += [[sum]]
    return res

def plot_ellipse(tup,wid,high,ang):
    ellipse = Ellipse(xy=tup,width=2*wid,height=2*high,angle=ang)
    ellipse.set_fill(False)
    figure,setting = plt.subplots()
    setting.add_patch(ellipse)
    setting.set_aspect('equal')
    setting.autoscale()
    print('close figure to move further')
    plt.show()


shape = input('polygon or disc? ')
if shape == 'polygon':
    xcd = list(map(int,input('enter list of x coordinates ').split()))
    ycd = list(map(int,input('enter list of y coordinates ').split()))
    inputs = []
    a = list(map(str,input('enter command ').split()))
    inputs += [a]
    while True:
        a = list(map(str,input('enter another command or quit ').split()))
        if a == ['quit']:
            break
        inputs += [a]
    xcd.append(xcd[0])
    ycd.append(ycd[0])
    plt.plot(xcd,ycd)
    print('close the figure to move further')
    plt.show()
    xcd.pop()
    ycd.pop()   
    

    for i in inputs:
        for j in range(len(xcd)):
            if i[0] == 'S':
                scale = l_scale(xcd[j],ycd[j],int(i[1]),int(i[2]))
                xcd[j] = scale[0][0]
                ycd[j] = scale[1][0]
            elif i[0] == 'T':
                translate = l_translate(xcd[j],ycd[j],int(i[1]),int(i[2]))
                xcd[j] = translate[0][0]
                ycd[j] = translate[1][0]
            elif i[0] == 'R':
                rotate = l_rotate(xcd[j],ycd[j],int(i[1]))
                xcd[j] = rotate[0][0]
                ycd[j] = rotate[1][0]
        print('x coordiantes: '+str(xcd))
        print('y coordinates: '+str(ycd))
        xcd.append(xcd[0])
        ycd.append(ycd[0])
        plt.plot(xcd,ycd)
        print('close the figure to move further')
        plt.show()
        xcd.pop()
        ycd.pop()   

elif shape == 'disc':
    xcd=int(input('x coordinate of center: '))
    ycd=int(input('y coordinate of center: '))
    rx=int(input('radius: '))
    ry=rx

    inputs = []
    a = list(map(str,input('enter command: ').split()))
    inputs += [a]
    while True:
        a = list(map(str,input('enter next command or quit: ').split()))
        if a == ['quit']:
            break
        inputs += [a]

    plot_ellipse((xcd,ycd),rx,ry,0)

    rot = 0
    for i in inputs:
        if i[0] == 'S':
            rx = rx*(int(i[1]))
            ry = ry*(int(i[2]))
        elif i[0] == 'T':
            xcd = xcd + int(i[1])
            ycd = ycd + int(i[2])
        elif i[0] == 'R':
            rot = rot + int(i[1])
        print('x coordinate of center: '+str(xcd))
        print('y coordinate of center: '+str(ycd))
        print('x radius '+str(rx))
        print('y radius '+str(ry))

        plot_ellipse((xcd,ycd),rx,ry,rot)
    

        
