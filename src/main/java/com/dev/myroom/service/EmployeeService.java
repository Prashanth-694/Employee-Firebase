package com.dev.myroom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.myroom.config.FirebaseConfig;
import com.dev.myroom.entity.Employee;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class EmployeeService {
    
	public String insertEmployee(Employee employee) throws InterruptedException, ExecutionException {
		
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection("Sample").document(employee.getId()).set(employee);
		return apiFuture.get().getUpdateTime().toString();
	}

	public Employee getEmployeeById(String id) throws InterruptedException, ExecutionException {
		Firestore firestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = firestore.collection("Sample").document(id);
		ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
		DocumentSnapshot documentSnapshot = apiFuture.get();
		return documentSnapshot.toObject(Employee.class);
	}

	public List<Employee> getAllEmployees() throws InterruptedException, ExecutionException {

		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = firestore.collection("Sample").get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Employee> list = new ArrayList<>();
		for (QueryDocumentSnapshot document : documents) {
			System.out.println(
					document.getId() + document.getString("name") + " => " + document.toObject(Employee.class));
			list.add(document.toObject(Employee.class));
		}
		return list;

	}

	public List<Employee> getByIdAndName(Employee employee) throws InterruptedException, ExecutionException {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<QuerySnapshot> future = firestore.collection("Sample").whereEqualTo("id", employee.getId())
				.whereEqualTo("name", employee.getName()).get();

		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Employee> list = new ArrayList<>();
		for (DocumentSnapshot document : documents) {
			list.add(document.toObject(Employee.class));
			System.out.println(document.getId() + " => " + document.toObject(Employee.class));
		}
		return list;
	}
	
	public String updateEmployee(Employee employee) throws InterruptedException, ExecutionException {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection("Sample").document(employee.getId()).set(employee);
		return apiFuture.get().getUpdateTime().toString();
	}
	
	public String deleteEmployee(String id) throws InterruptedException, ExecutionException {
		Firestore firestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> apiFuture = firestore.collection("Sample").document(id).delete();
		return "Deleted Successfully "+id; 
	}
}
