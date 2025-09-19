import openai
import os
import google.auth
from googleapiclient.discovery import build
from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow

# Configuración de la API de OpenAI
openai.api_key = 'TU_CLAVE_API_OPENAI'

# Función para obtener un chiste informático de la API de OpenAI
def obtener_chiste_informatico():
    prompt = "Dame un chiste informático"
    response = openai.Completion.create(
        engine="text-davinci-003",  # Puedes usar otro modelo disponible
        prompt=prompt,
        max_tokens=50
    )
    return response.choices[0].text.strip()

# Configuración de la API de Google Classroom
SCOPES = ['https://www.googleapis.com/auth/classroom.courses', 'https://www.googleapis.com/auth/classroom.announcements']
creds = None

# El token de acceso guardado se debe generar solo una vez mediante el flujo de OAuth
if os.path.exists('token.json'):
    creds = Credentials.from_authorized_user_file('token.json', SCOPES)
else:
    flow = InstalledAppFlow.from_client_secrets_file(
        'credentials.json', SCOPES)
    creds = flow.run_local_server(port=0)
    with open('token.json', 'w') as token:
        token.write(creds.to_json())

# Construir el servicio de Google Classroom
service = build('classroom', 'v1', credentials=creds)

# Función para publicar el chiste en el foro de la clase
def publicar_en_foro_classroom(course_id, chiste):
    # Crear un anuncio en el foro de la clase
    announcement = {
        'text': chiste,
        'state': 'PUBLISHED'  # Asegúrate de que el anuncio esté publicado
    }

    # Crear el anuncio en el curso
    service.courses().announcements().create(courseId=course_id, body=announcement).execute()

# Ejemplo de uso
course_id = 'Njg1NjY4NDE0NTM4'  # ID de Entorno servidor

# Obtener un chiste y publicarlo en el foro de la clase
chiste = obtener_chiste_informatico()
publicar_en_foro_classroom(course_id, chiste)

course_id = 'NzEzMDgyNzAxMTg0' # ID de programacion
print("Chiste publicado en el foro: ", chiste)

# Obtener un chiste y publicarlo en el foro de la clase
chiste = obtener_chiste_informatico()
publicar_en_foro_classroom(course_id, chiste)
