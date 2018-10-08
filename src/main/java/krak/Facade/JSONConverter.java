package krak.facade;

import krak.dto.AddressDTO;
import krak.dto.CityDTO;
import krak.dto.HobbyDTO;
import krak.dto.PersonDTO;
import krak.dto.PhoneDTO;
import krak.entities.Address;
import krak.entities.Cityinfo;
import krak.entities.Hobby;
import krak.entities.Person;
import krak.entities.Phone;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

public class JSONConverter {

    //MAKE THIS CLASS GENERIC AND MAKE FACADES IMPLEMENT
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    //ADDRESSES JSONCONVERTERS
    public String getJSONfromAddress(Address address) {
        return gson.toJson(new AddressDTO(address));
    }

    public String getAddressFromJson(String json) {
        return null;
    }

    public String getJsonFromAddresses(List<Address> addresses) {
        List<AddressDTO> addressDTOList = new ArrayList();
        for (Address address : addresses) {
            addressDTOList.add(new AddressDTO(address));
        }
        return gson.toJson(addressDTOList);
    }

    public String getJsonFromAddressDTO(AddressDTO addressDTO) {
        return gson.toJson(addressDTO);
    }

    //CITYINFOS JSONCONVERTERS
    public String getJsonFromCityinfo(Cityinfo cityinfo) {
        return gson.toJson(cityinfo);
    }

    public String getCityinfoFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromCityinfos(List<Cityinfo> cityinfos) {
        List<CityDTO> cityDTOList = new ArrayList();
        for (Cityinfo city : cityinfos) {
            cityDTOList.add(new CityDTO(city));
        }
        return gson.toJson(cityDTOList);
    }

    public String getJsonFromCityDTO(CityDTO cityDTO) {
        return gson.toJson(cityDTO);
    }

    //HOBBIES JSONCONVERTERS
    public String getJsonFromHobby(Hobby hobby) {
        return gson.toJson(hobby);

    }

    public String getHobbyFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromHobbies(List<Hobby> hobbies) {
        List<HobbyDTO> hobbyDTOList = new ArrayList();
        for (Hobby hobby : hobbies) {
            hobbyDTOList.add(new HobbyDTO(hobby));
        }
        return gson.toJson(hobbyDTOList);
    }

    public String getJsonFromHobbyDTO(HobbyDTO hobbyDTO) {
        return gson.toJson(hobbyDTO);
    }

    //PERSONS JSONCONVERTERS
    public String getJsonFromPerson(Person person) {
        return gson.toJson(person);

    }

    public String getPersonFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromPersons(List<Person> persons) {
        List<PersonDTO> personDTOList = new ArrayList();
        for (Person person : persons) {
            personDTOList.add(new PersonDTO(person));
        }
        return gson.toJson(personDTOList);
    }

    public String getJsonFromPersonDTO(PersonDTO personDTO) {
        return gson.toJson(personDTO);
    }

    //PHONES JSONCONVERTERS
    public String getJsonFromPhone(Phone phone) {
        return gson.toJson(phone);

    }

    public String getPhoneFromJson(String json) {
        return gson.toJson(json);
    }

    public String getJsonFromPhones(List<Phone> phones) {
        List<PhoneDTO> phoneDTOList = new ArrayList();
        for (Phone phone : phones) {
            phoneDTOList.add(new PhoneDTO(phone));
        }
        return gson.toJson(phoneDTOList);
    }

    public String getJsonFromPhoneDTO(PhoneDTO phoneDTO) {
        return gson.toJson(phoneDTO);
    }

}
