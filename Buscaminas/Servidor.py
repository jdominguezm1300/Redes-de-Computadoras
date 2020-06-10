import socket
import random
import struct
import os

# Creamos las funciones que operarán el juego

def crearEstructura(dificultad):
    tablero, fila = [], []
    if dificultad == 1:
        max_x, max_y = 8,8
    elif dificultad == 2:
        max_x, max_y = 16,16
    elif dificultad == 3:
        max_x, max_y = 16,30
    for j in range(0,max_x):
        fila.append(0)
    for i in range(0,max_y):
        tablero.append(fila.copy())
    return tablero

def obtenerCoordenadasMinas(dificultad):
    minas = []
    print("Dificultad: " + str(dificultad))
    if dificultad == 1:
        max_minas, max_x, max_y = 10,7,7
    elif dificultad == 2:
        max_minas, max_x, max_y = 40,15,15
    elif dificultad == 3:
        max_minas, max_x, max_y = 99,15,29
    for i in range(0,max_minas):
        posicionX = random.randint(0,max_x)
        posicionY = random.randint(0,max_y)
        mina = (posicionX, posicionY)
        minas.append(mina)
    return minas

def colocarMinas(minas,tablero):
    for coordenada in minas:
        x = coordenada[0]
        y = coordenada[1]
        tablero[y][x] = 'M'
    return tablero

def colocarNumeros(tablero):
    contadorMinas = 0
    final = len(tablero[0]) - 1
    finalY = len(tablero) - 1
    for i in range(len(tablero[0])):
        for j in range(len(tablero)):
            if tablero[j][i] == 'M':
                pass
            else:
                # Revisamos si se trata de una esquina
                # Superior izquierda
                if i == 0 and j == 0:
                    if tablero[0][1] == 'M':
                        contadorMinas += 1
                    if tablero[1][0] == 'M':
                        contadorMinas += 1
                    if tablero[1][1] == 'M':
                        contadorMinas += 1
                # Superior derecha
                elif i == final and j == 0:
                    if tablero[0][final-1] == 'M':
                        contadorMinas += 1
                    if tablero[1][final] == 'M':
                        contadorMinas += 1
                    if tablero[1][final-1] == 'M':
                        contadorMinas += 1
                # Inferior izquierda
                elif i == 0 and j == finalY:
                    if tablero[finalY-1][0] == 'M':
                        contadorMinas += 1
                    if tablero[finalY-1][1] == 'M':
                        contadorMinas += 1
                    if tablero[finalY][1] == 'M':
                        contadorMinas += 1
                # Inferior derecha
                elif i == final and j == finalY:
                    if tablero[finalY][final-1] == 'M':
                        contadorMinas += 1
                    if tablero[finalY-1][final-1] == 'M':
                        contadorMinas += 1
                    if tablero[finalY-1][final] == 'M':
                        contadorMinas += 1
                # Si por el contrario se trata de alguno de los bordes se hace el siguiente cálculo
                # Borde superior
                elif j == 0:
                    if tablero[j][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i-1] == 'M':
                        contadorMinas += 1
                # Borde izquierdo
                elif i == 0:
                    if tablero[j-1][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i] == 'M':
                        contadorMinas += 1
                # Borde derecho
                elif i == final:
                    if tablero[j-1][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i] == 'M':
                        contadorMinas += 1
                # Borde inferior
                elif j == finalY:
                    if tablero[j-1][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i+1] == 'M':
                        contadorMinas += 1
                # Si se trata de cualquier otra casilla ya la armamos
                else:
                    if tablero[j-1][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j-1][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j][i+1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i-1] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i] == 'M':
                        contadorMinas += 1
                    if tablero[j+1][i+1] == 'M':
                        contadorMinas += 1
                tablero[j][i] = contadorMinas
                contadorMinas = 0
    return tablero

def crearTablero(dificultad):
    tablero, minas = [], []
    # Tenemos 3 dificultades:
    # 1: Fácil, tablero de 8x8 con 10 minas
    # 2: Intermedio, tablero de 16x16 con 40 minas
    # 3: Experto, tablero de 16x30 casillas con 99 minas
    # Primero obtenemos las posiciones aleatorias de las bombas en el tablero
    minas = obtenerCoordenadasMinas(dificultad)
    # Creamos la estructura en sí misma del tablero, con una lista de listas
    tablero = crearEstructura(dificultad)
    # Colocamos las minas (-1) en la estructura del tablero
    tablero = colocarMinas(minas,tablero)
    # Finalmente colocamos los números para las pistas de las minas
    tablero = colocarNumeros(tablero)
    return tablero

def escribirArchivo(tablero):
    i = 0
    archivo = open("tablero.txt","w+")
    for fila in tablero:
        for casilla in fila:
            if i == (len(tablero) - 1):
                if casilla != 'M':
                    archivo.write("%d" % casilla)
                else:
                    archivo.write("%s" % casilla)
            else:
                if casilla != 'M':
                    archivo.write("%d " % casilla)
                else:
                    archivo.write("%s " % casilla)
            i += 1
        archivo.write("\n")
        i = 0
    archivo.close()
    return

def escribirPuntaje(nombre,puntaje):
    archivo = open("puntajes.txt","w")
    archivo.write("%s\t%d" % (nombre,puntaje))
    archivo.close()
    return

def main():
    # Creamos el socket
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    host = "127.0.0.1"
    port = 10004
    server.bind((host,port))
    server.listen(5)

    while True:
        conn, addr = server.accept()
        print("Conectado desde %s " % str(addr))
        # Recibimos la dificultad que necesita el cliente
        conn.sendall(struct.pack('i',5))
        datos = conn.recv(1024)
        print("Datos: " + str(datos))
        dificultad = int.from_bytes(datos,byteorder='big')
        tablero = crearTablero(dificultad)
        escribirArchivo(tablero)
        # Enviamos el archivo con los datos del tablero al cliente
        statinfo = os.stat('tablero.txt')
        nbytes = struct.pack('i',statinfo.st_size)
        #tam = bytes([nbytes])
        conn.send(nbytes)
        try:
            archivo = open('tablero.txt','rb')
            linea = archivo.read(1024)
            while linea:
                conn.send(linea)
                linea = archivo.read(1024)
        #    conn.send(archivo.read(1024))
            archivo.close()
        except IOError:
            pass
        finally:
            while True:
                datos = conn.recv(1024)
                salir = int.from_bytes(datos,byteorder='big')
                print(str(salir))
                if salir == 1:
                    break
            # Si perdió el cliente entonces almacenamos un nombre y un puntaje en un archivo
            datos = conn.recv(1024)
            nombre = datos.decode("utf-8")
            print("Puntaje: " + nombre)
            datos = conn.recv(1024)
            puntaje = int.from_bytes(datos,byteorder='big')
            print(str(puntaje))
            escribirPuntaje(nombre,puntaje)
            conn.close()

main()
