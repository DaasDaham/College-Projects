# Saad Ahmad
# Roll no.- 2018409
# Section-B
# Group 2

import urllib.request 
import datetime
import urllib.error
#import datetime library to get responses for nth day from current date
todays_date = int(datetime.datetime.today().day)

# function to get weather response
# location and API_key are to be entered as strings
def weather_response(location, API_key):
    try:
        url = "http://api.openweathermap.org/data/2.5/forecast?q="+str(location)+"&APPID="+str(API_key)
        x = urllib.request.urlopen(url).read().decode("utf-8")
        return x
    except urllib.error.HTTPError as errorMessage:
        if errorMessage.code == 404:
            print('{"cod":"404","message":"city not found"}')
        elif errorMessage.code == 401:
            print('{"cod":401, "message": "Invalid API key."}')		
   

# function to check for valid response 
# enter location string with first letter as capital. Example- "Delhi", "Tokyo", etc.
def has_error(location,json):
	if str(location) not in str(json):
		return True
	else:
	    return ""	
	

# Returns the value of temperature on nth day from current date 
# n is to be entered as an integer. 0 =< n =< 4
# enter json string in single quotes to avoid errors
def get_temperature(json, n=0, t="03:00:00"):
    if n + todays_date < 10:
        orderedString = "2018-09-0" + str(n + todays_date) + " " + str(t)
    else:
        orderedString = "2018-09-" + str(n + todays_date) + " " + str(t)
    json = json[::-1]
    e = json.find(orderedString[::-1])
    a = json.find(":\"pmet\"", e+1)
    s = json[a-5:a]
    y = s[::-1]
    return float(y)

# Returns the value of humidity on nth day from current date 
# n is to be entered as an integer. 0 =< n =< 4
# enter json string in single quotes to avoid errors
def get_humidity(json, n=0, t="03:00:00"):
    if n + todays_date < 10:
        orderedString = "2018-09-0" + str(n + todays_date) + " " + str(t)
    else:
        orderedString = "2018-09-" + str(n + todays_date) + " " + str(t)
    json = json[::-1]
    e = json.find(orderedString[::-1])
    a = json.find(":\"ytidimuh\"", e+1)
    s = json[a-2:a]
    y = s[::-1]
    return float(y)

# Returns the value of pressure on nth day from current date
# n is to be entered as an integer. 0 =< n =< 4
# enter json string in single quotes to avoid errors
def get_pressure(json, n=0, t="03:00:00"):
	if n + todays_date < 10:
		orderedString = "2018-09-0" + str(n + todays_date) + " " + str(t)
	else:
		orderedString = "2018-09-" + str(n + todays_date) + " " + str(t)
	json = json[::-1]
	e = json.find(orderedString[::-1])
	a = json.find(":\"erusserp\"", e+1)
	s = json[a-5:a]
	y = s[::-1]
	return float(y) 

# Returns the value of wind speed on nth day from current date
# n is to be entered as an integer. 0 =< n =< 4
# enter json string in single quotes to avoid errors
def get_wind(json, n=0, t="03:00:00"):
	if n + todays_date < 10:
		orderedString = "2018-09-0" + str(n + todays_date) + " " + str(t)
	else:
		orderedString = "2018-09-" + str(n + todays_date) + " " + str(t)
	json = json[::-1]
	e = json.find(orderedString[::-1])
	a = json.find(":\"deeps\"", e+1)
	s = json[a-3:a]
	y = s[::-1]
	return float(y)

# Returns the value of sea level on nth day from current date
# n is to be entered as an integer. 0 =< n =< 4
# enter json string in single quotes to avoid errors
def get_sealevel(json, n=0, t="03:00:00"):
	if n + todays_date < 10:
		orderedString = "2018-09-0" + str(n + todays_date) + " " + str(t)
	else:
		orderedString = "2018-09-" + str(n + todays_date) + " " + str(t)
	json = json[::-1]
	e = json.find(orderedString[::-1])
	a = json.find(":\"level_aes\"", e+1)
	s = json[a-6:a]
	y = s[::-1]
	return float(y)




